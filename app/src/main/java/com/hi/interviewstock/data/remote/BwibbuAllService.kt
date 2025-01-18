package com.hi.interviewstock.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BWIBBUALLRetrofitInstance {
    private const val BASE_URL = "https://openapi.twse.com.tw/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
