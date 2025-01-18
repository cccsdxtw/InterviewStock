package com.hi.interviewstock.data.remote

import com.hi.interviewstock.domain.model.BwlbbuAllInfoItem
import com.hi.interviewstock.domain.model.StockDayAllInfoItem
import com.hi.interviewstock.domain.model.StockDayAvgAllInfoItem
import retrofit2.http.GET

interface BwlbbuAllService {
    @GET("v1/api/exchangeReport/BWIBBU_ALL")
    suspend fun fetchBwlbbuAllInfo(): List<BwlbbuAllInfoItem>
}
interface StockDayAllService {
    @GET("v1/api/exchangeReport/STOCK_DAY_ALL")
    suspend fun fetchStockDayAllInfo(): List<StockDayAllInfoItem>
}
interface StockDayAvgAllService {
     @GET("v1/api/exchangeReport/STOCK_DAY_AVG_ALL")
    suspend fun fetchStockDayAvgAllInfo(): List<StockDayAvgAllInfoItem>
}