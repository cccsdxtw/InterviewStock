package com.hi.interviewstock.data.remote

import com.hi.interviewstock.domain.model.BwibbuAllInfoItem
import retrofit2.http.GET

interface BWIBBUALLService {
    @GET("v1/api/exchangeReport/BWIBBU_ALL")
    suspend fun fetchBWIBBUALLInfo(): List<BwibbuAllInfoItem>
}
