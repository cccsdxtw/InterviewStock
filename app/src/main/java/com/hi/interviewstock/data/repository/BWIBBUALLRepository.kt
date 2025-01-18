package com.hi.interviewstock.data.repository

import com.hi.interviewstock.data.remote.BWIBBUALLService
import com.hi.interviewstock.domain.model.BWIBBUALLInfoItem

class BWIBBUALLRepository(private val api: BWIBBUALLService) {
    suspend fun fetchReservoirInfoList(): List<BWIBBUALLInfoItem> {
        return api.fetchBWIBBUALLInfo()
    }
}
