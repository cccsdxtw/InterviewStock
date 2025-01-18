package com.hi.interviewstock.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRetrofitProvider {
    private const val OPENAOI_URL = "https://openapi.twse.com.tw/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(OPENAOI_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
