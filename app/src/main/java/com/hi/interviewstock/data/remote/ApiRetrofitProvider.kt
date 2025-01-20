package com.hi.interviewstock.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 定義一個單例物件，提供 Retrofit 實例
object ApiRetrofitProvider {

    // 定義 API 的 base URL（這裡使用的是台灣證券交易所的開放 API）
    private const val OPENAOI_URL = "https://openapi.twse.com.tw/"

    // 使用 lazy 委託，當需要使用 Retrofit 實例時才會初始化
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(OPENAOI_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
