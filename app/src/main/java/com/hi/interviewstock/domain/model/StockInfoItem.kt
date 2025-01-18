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


data class ALLInfoItem(
    // 股票代碼，預設值為 "沒有資料"
    @SerializedName("Code")
    val code: String? = "沒有資料",

    // 股票名稱，預設值為 "沒有資料"
    @SerializedName("Name")
    val name: String? = "沒有資料",

    // 本益比（PE Ratio），預設值為 "沒有資料"
    @SerializedName("PEratio")
    val peRatio: String? = "沒有資料",

    // 股息殖利率，預設值為 "沒有資料"
    @SerializedName("DividendYield")
    val dividendYield: String? = "沒有資料",

    // 市價比（PB Ratio），預設值為 "沒有資料"
    @SerializedName("PBratio")
    val pbRatio: String? = "沒有資料",

    // 收盤價，預設值為 "沒有資料"
    @SerializedName("ClosingPrice")
    val closingPrice: String? = "沒有資料",

    // 月平均價格，預設值為 "沒有資料"
    @SerializedName("MonthlyAveragePrice")
    val monthlyAveragePrice: String? = "沒有資料",

    // 交易量，預設值為 "沒有資料"
    @SerializedName("TradeVolume")
    val tradeVolume: String? = "沒有資料",

    // 交易金額，預設值為 "沒有資料"
    @SerializedName("TradeValue")
    val tradeValue: String? = "沒有資料",

    // 開盤價，預設值為 "沒有資料"
    @SerializedName("OpeningPrice")
    val openingPrice: String? = "沒有資料",

    // 最高價，預設值為 "沒有資料"
    @SerializedName("HighestPrice")
    val highestPrice: String? = "沒有資料",

    // 最低價，預設值為 "沒有資料"
    @SerializedName("LowestPrice")
    val lowestPrice: String? = "沒有資料",

    // 漲跌價差，預設值為 "沒有資料"
    @SerializedName("Change")
    val change: String? = "沒有資料",

    // 交易次數，預設值為 "沒有資料"
    @SerializedName("Transaction")
    val transaction: String? = "沒有資料",
)