package com.hi.interviewstock.data.remote

import com.hi.interviewstock.domain.model.BWIBBUALLInfoItem
import retrofit2.http.GET

interface BWIBBUALLService {
    @GET("v1/api/exchangeReport/BWIBBU_ALL")
    suspend fun fetchBWIBBUALLInfo(): List<BWIBBUALLInfoItem>
}
