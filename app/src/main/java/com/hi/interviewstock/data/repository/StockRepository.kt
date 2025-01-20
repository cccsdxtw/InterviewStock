package com.hi.interviewstock.data.repository

import com.hi.interviewstock.data.remote.BwlbbuAllService
import com.hi.interviewstock.data.remote.StockDayAllService
import com.hi.interviewstock.data.remote.StockDayAvgAllService
import com.hi.interviewstock.domain.model.BwlbbuAllInfoItem
import com.hi.interviewstock.domain.model.StockDayAllInfoItem
import com.hi.interviewstock.domain.model.StockDayAvgAllInfoItem

// 用於處理來自 BWIBBU_ALL 資料源的資料
class BwlbbuAllRepository(private val api: BwlbbuAllService) {
    // 返回 BwlbbuAllInfoItem 列表
    suspend fun fetchReservoirInfoList(): List<BwlbbuAllInfoItem> {
        return api.fetchBwlbbuAllInfo()
    }
}

// 用於處理來自 STOCK_DAY_ALL 資料源的資料
class StockDayAllRepository(private val api: StockDayAllService) {
    // 返回 StockDayAllInfoItem 列表
    suspend fun fetchReservoirInfoList(): List<StockDayAllInfoItem> {
        return api.fetchStockDayAllInfo()
    }
}

// 用於處理來自 STOCK_DAY_AVG_ALL 資料源的資料
class StockDayAvgAllRepository(private val api: StockDayAvgAllService) {
    //返回 StockDayAvgAllInfoItem 列表
    suspend fun fetchReservoirInfoList(): List<StockDayAvgAllInfoItem> {
        return api.fetchStockDayAvgAllInfo()
    }
}
