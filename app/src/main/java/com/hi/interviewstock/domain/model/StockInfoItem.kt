package com.hi.interviewstock.domain.model

import com.google.gson.annotations.SerializedName


data class BwlbbuAllInfoItem(
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
) {}

data class StockDayAllInfoItem(

    //股票代號
    @SerializedName("Code")
    val Code: String? = "沒有資料",
    //股票名稱
    @SerializedName("Name")
    val Name: String? = "沒有資料",
    //成交股數
    @SerializedName("TradeVolume")
    val TradeVolume: String? = "沒有資料",
    //成交金額
    @SerializedName("TradeValue")
    val TradeValue: String? = "沒有資料",
    //開盤價
    @SerializedName("OpeningPrice")
    val OpeningPrice: String? = "沒有資料",
    //最高價
    @SerializedName("HighestPrice")
    val HighestPrice: String? = "沒有資料",
    //最低價
    @SerializedName("LowestPrice")
    val LowestPrice: String? = "沒有資料",
    //收盤
    @SerializedName("ClosingPrice")
    val ClosingPrice: String? = "沒有資料",
    //漲跌價差
    @SerializedName("Change")
    val Change: String? = "沒有資料",
    //成交筆數
    @SerializedName("Transaction")
    val Transaction: String? = "沒有資料",
) {}

data class StockDayAvgAllInfoItem(
    //股票代號
    @SerializedName("Code")
    val Code: String? = "沒有資料",
    //股票名稱
    @SerializedName("Name")
    val Name: String? = "沒有資料",
    //收盤價
    @SerializedName("ClosingPrice")
    val ClosingPrice: String? = "沒有資料",
    //月平均價
    @SerializedName("MonthlyAveragePrice")
    val MonthlyAveragePrice: String? = "沒有資料",
) {}
