package com.hi.interviewstock.domain.model

import com.google.gson.annotations.SerializedName


data class BwibbuAllInfoItem(
    //股票代號
    @SerializedName("Code")
    val Code: String? = "沒有資料",
    //股票名稱
    @SerializedName("Name")
    val Name: String? = "沒有資料",
    //本益比
    @SerializedName("PEratio")
    val PEratio: String? = "沒有資料",
    //殖利率(%)
    @SerializedName("DividendYield")
    val DividendYield: String? = "沒有資料",
    //股價淨值比
    @SerializedName("PBratio")
    val PBratio: String? = "沒有資料",
) {
//    val status: AirportStatus get() = AirportStatus.fromValue(""+airFlyStatus)

}