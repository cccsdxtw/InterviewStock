package com.hi.interviewstock.data.repository

import com.hi.interviewstock.data.remote.BwlbbuAllService
import com.hi.interviewstock.data.remote.StockDayAllService
import com.hi.interviewstock.data.remote.StockDayAvgAllService
import com.hi.interviewstock.domain.model.BwlbbuAllInfoItem
import com.hi.interviewstock.domain.model.StockDayAllInfoItem
import com.hi.interviewstock.domain.model.StockDayAvgAllInfoItem

class BwlbbuAllRepository(private val api: BwlbbuAllService) {
    suspend fun fetchReservoirInfoList(): List<BwlbbuAllInfoItem> {
        return api.fetchBwlbbuAllInfo()
    }
}
class StockDayAllRepository(private val api: StockDayAllService) {
    suspend fun fetchReservoirInfoList(): List<StockDayAllInfoItem> {
        return api.fetchStockDayAllInfo()
    }
}
class StockDayAvgAllRepository(private val api: StockDayAvgAllService) {
    suspend fun fetchReservoirInfoList(): List<StockDayAvgAllInfoItem> {
        return api.fetchStockDayAvgAllInfo()
    }
}