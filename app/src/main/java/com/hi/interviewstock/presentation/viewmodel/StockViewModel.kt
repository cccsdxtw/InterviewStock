package com.hi.interviewstock.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hi.interviewstock.data.repository.BwlbbuAllRepository
import com.hi.interviewstock.data.repository.StockDayAllRepository
import com.hi.interviewstock.data.repository.StockDayAvgAllRepository
import com.hi.interviewstock.domain.model.ALLInfoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.State

@HiltViewModel
class StockViewModel @Inject constructor(
    private val bwlbbuAllRepository: BwlbbuAllRepository,
    private val stockDayAllRepository: StockDayAllRepository,
    private val stockDayAvgAllRepository: StockDayAvgAllRepository
) : ViewModel() {
    val isLoading = mutableStateOf(true)  // 控制是否顯示加載動畫
    val stockData = mutableStateOf<List<ALLInfoItem>>(emptyList())  // 儲存 API 資料

    private val _allInfoItems = MutableStateFlow<List<ALLInfoItem>>(emptyList())
    val allInfoItems: StateFlow<List<ALLInfoItem>> get() = _allInfoItems
//    private val _isBottomSheetVisible = mutableStateOf(false)
    private val _isDropdownMenuExpanded = mutableStateOf(false)
    val isBottomSheetVisible: State<Boolean> get() = _isDropdownMenuExpanded


    fun fetchReservoirInfoList() {
        viewModelScope.launch {
            try {
                // 獲取三個不同的 API 資料
                val bwlbbuAllData = bwlbbuAllRepository.fetchReservoirInfoList()
                val stockDayAllData = stockDayAllRepository.fetchReservoirInfoList()
                val stockDayAvgAllData = stockDayAvgAllRepository.fetchReservoirInfoList()

                // 合併資料並映射到 ALLInfoItem
                val mergedData = mergeData(
                    bwlbbuAllData,
                    stockDayAllData,
                    stockDayAvgAllData
                )
                // 更新資料和加載狀態
                _allInfoItems.value = mergedData
                stockData.value = mergedData
                isLoading.value = false
                Log.e(" isLoading.value:", isLoading.value.toString())
            } catch (e: Exception) {
                e.printStackTrace()
                isLoading.value = false
                _allInfoItems.value = emptyList() // 發生錯誤時回傳空列表
                Log.e(" isLoading.value:", isLoading.value.toString())

            }
        }
    }

    private fun mergeData(
        bwlbbuAllData: List<com.hi.interviewstock.domain.model.BwlbbuAllInfoItem>,
        stockDayAllData: List<com.hi.interviewstock.domain.model.StockDayAllInfoItem>,
        stockDayAvgAllData: List<com.hi.interviewstock.domain.model.StockDayAvgAllInfoItem>
    ): List<ALLInfoItem> {
        // 使用 associateBy 將三個資料列表轉換成以 Code 為鍵的 Map
        val bwibbuMap = bwlbbuAllData.associateBy { it.Code } // BWIBBUALL 資料列表轉換成 Map
        val stockDayMap = stockDayAllData.associateBy { it.Code } // STOCKDAYALL 資料列表轉換成 Map
        val stockDayAvgMap = stockDayAvgAllData.associateBy { it.Code } // STOCKDAYAVGALL 資料列表轉換成 Map

        // 取得所有唯一的 Code，這些 Code 會來自三個資料來源
        val allCodes = (bwibbuMap.keys + stockDayMap.keys + stockDayAvgMap.keys).distinct()

        // 透過所有的唯一 Code，將資料合併成 ALLInfoItem 物件
        return allCodes.map { code ->
            // 根據 Code 從三個資料源中擷取對應的資料
            val bwibbu = bwibbuMap[code] // 從 BWIBBUALL 資料中取得資料
            val stockDay = stockDayMap[code] // 從 STOCKDAYALL 資料中取得資料
            val stockDayAvg = stockDayAvgMap[code] // 從 STOCKDAYAVGALL 資料中取得資料

            // 建立 ALLInfoItem 物件，並填入對應的資料
            ALLInfoItem(
                code = code ?: "沒有資料", // 如果沒有找到對應的 Code，則顯示 "沒有資料"
                name = bwibbu?.Name ?: stockDay?.Name ?: stockDayAvg?.Name ?: "沒有資料", // 如果三者都沒有名稱，則顯示 "沒有資料"
                peRatio = bwibbu?.PEratio, // PE ratio 來自 BWIBBUALL 資料
                dividendYield = bwibbu?.DividendYield, // Dividend yield 來自 BWIBBUALL 資料
                pbRatio = bwibbu?.PBratio, // PB ratio 來自 BWIBBUALL 資料
                closingPrice = stockDay?.ClosingPrice ?: stockDayAvg?.ClosingPrice, // ClosingPrice 來自 STOCKDAYALL 或 STOCKDAYAVGALL 資料
                monthlyAveragePrice = stockDayAvg?.MonthlyAveragePrice, // MonthlyAveragePrice 來自 STOCKDAYAVGALL 資料
                tradeVolume = stockDay?.TradeVolume, // TradeVolume 來自 STOCKDAYALL 資料
                tradeValue = stockDay?.TradeValue, // TradeValue 來自 STOCKDAYALL 資料
                openingPrice = stockDay?.OpeningPrice, // OpeningPrice 來自 STOCKDAYALL 資料
                highestPrice = stockDay?.HighestPrice, // HighestPrice 來自 STOCKDAYALL 資料
                lowestPrice = stockDay?.LowestPrice, // LowestPrice 來自 STOCKDAYALL 資料
                change = stockDay?.Change, // Change 來自 STOCKDAYALL 資料
                transaction = stockDay?.Transaction // Transaction 來自 STOCKDAYALL 資料
            )
        }
            // 根據 code 排序結果，並返回合併後的資料列表
            .sortedBy { it.code }
    }

    fun openDropdownMenu() {
        _isDropdownMenuExpanded.value = true
    }

    fun closeDropdownMenu() {
        _isDropdownMenuExpanded.value = false
    }

}
