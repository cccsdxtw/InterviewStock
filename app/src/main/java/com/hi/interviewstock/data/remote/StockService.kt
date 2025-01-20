package com.hi.interviewstock.data.remote

import com.hi.interviewstock.domain.model.BwlbbuAllInfoItem
import com.hi.interviewstock.domain.model.StockDayAllInfoItem
import com.hi.interviewstock.domain.model.StockDayAvgAllInfoItem
import retrofit2.http.GET

// 定義接口，用於獲取 BWIBBU_ALL 資料
interface BwlbbuAllService {
    // 使用 GET
    @GET("v1/api/exchangeReport/BWIBBU_ALL")
    suspend fun fetchBwlbbuAllInfo(): List<BwlbbuAllInfoItem>
}

// 定義接口，用於獲取 STOCK_DAY_ALL 資料
interface StockDayAllService {
    // 使用 GET
    @GET("v1/api/exchangeReport/STOCK_DAY_ALL")
    suspend fun fetchStockDayAllInfo(): List<StockDayAllInfoItem>
}

// 定義接口，用於獲取 STOCK_DAY_AVG_ALL 資料
interface StockDayAvgAllService {
    // 使用 GET
    @GET("v1/api/exchangeReport/STOCK_DAY_AVG_ALL")
    suspend fun fetchStockDayAvgAllInfo(): List<StockDayAvgAllInfoItem>
}
