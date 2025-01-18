package com.hi.interviewstock.data.repository

import com.hi.interviewstock.data.remote.BWIBBUALLService
import com.hi.interviewstock.domain.model.BwibbuAllInfoItem

class BwibbuAllRepository(private val api: BWIBBUALLService) {
    suspend fun fetchReservoirInfoList(): List<BwibbuAllInfoItem> {
        return api.fetchBWIBBUALLInfo()
    }
}
