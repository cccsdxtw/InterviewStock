package com.hi.interviewstock.presentation.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.hi.interviewstock.presentation.viewmodel.StockViewModel

@Composable
fun StockScreen(type: String,viewModel: StockViewModel = hiltViewModel()) {
    val items = viewModel.allInfoItems.collectAsState(initial = emptyList())

    // 排序後的列表
    val sortedItems = remember(items.value) {
        if(type == "升") {
            items.value.sortedBy { it.code } // 這裡是升冪排序，根據你的需求更改排序方式
        }else{
            items.value.sortedByDescending { it.code }
        }


    }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(sortedItems.size) { index ->
            val sortedItems = sortedItems[index]
            // 當 openDialog 為 true 時顯示一個 Dialog
            val openDialog = remember { mutableStateOf(false) }
            if (openDialog.value) {
                Dialog(onDismissRequest = { openDialog.value = false }) {
                    // Dialog 中使用 Card 顯示股票詳細資訊
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        shape = RoundedCornerShape(16.dp),
                    ) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            // 占位 Box，為 Dialog 頂部留出空白
                            Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {}
                            // 顯示本益比
                            Row(
                                Modifier.weight(1.0f),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {
                                    Text("本益比", fontSize = 10.sp, textAlign = TextAlign.Left)
                                }
                                Box(Modifier.weight(2.0f), contentAlignment = Alignment.Center) {
                                    Text(
                                        sortedItems.peRatio ?: "沒有資料",
                                        fontSize = 15.sp,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                            // 顯示殖利率
                            Row(
                                Modifier.weight(1.0f),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {
                                    Text("殖利率", fontSize = 10.sp, textAlign = TextAlign.Left)
                                }
                                Box(Modifier.weight(2.0f), contentAlignment = Alignment.Center) {
                                    Text(
                                        sortedItems.dividendYield ?: "沒有資料",
                                        fontSize = 15.sp,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                            // 顯示股價淨值比
                            Row(
                                Modifier.weight(1.0f),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {
                                    Text("股價淨值比", fontSize = 10.sp, textAlign = TextAlign.Left)
                                }
                                Box(Modifier.weight(2.0f), contentAlignment = Alignment.Center) {
                                    Text(
                                        sortedItems.pbRatio ?: "沒有資料",
                                        fontSize = 15.sp,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                            // 占位 Box，為 Dialog 底部留出空白
                            Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {}
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.padding(4.dp)) // 在 Card 和其他元件間加間距

            // 主 Card，顯示股票基本資訊
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = if (isSystemInDarkTheme()) Color.DarkGray else Color.White
                ),
                elevation = CardDefaults.cardElevation(8.dp),
                onClick = {
                    // 點擊 Card 開啟 Dialog
                    openDialog.value = true
                }
            ) {
                Column(
                    Modifier.padding(10.dp, 10.dp, 10.dp, 20.dp)
                ) {
                    // 顯示股票代碼
                    Row { Text(sortedItems.code ?: "沒有資料", fontSize = 10.sp) }
                    // 顯示股票名稱
                    Row { Text(sortedItems.name ?: "沒有資料", fontSize = 22.sp) }
                    Row { Box(Modifier.size(0.dp, 10.dp)) } // 用於調整 Card 內部間距

                    // 開盤價與收盤價
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(Modifier.weight(1.0f)) {} // 空白占位
                        Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {
                            Text("開盤價", fontSize = 12.sp, textAlign = TextAlign.Left)
                        }
                        Box(Modifier.weight(2.0f), contentAlignment = Alignment.Center) {
                            Text(
                                sortedItems.openingPrice ?: "沒有資料",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                        Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {
                            Text("收盤價", fontSize = 12.sp, textAlign = TextAlign.Left)
                        }
                        // 根據收盤價與月平均價的比較，設定文字顏色
                        Box(Modifier.weight(2.0f), contentAlignment = Alignment.Center) {
                            Text(
                                text = sortedItems.closingPrice ?: "沒有資料",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Center,
                                color = when {
                                    sortedItems.closingPrice?.toFloatOrNull() ?: 0f > sortedItems.monthlyAveragePrice?.toFloatOrNull() ?: 0f -> Color.Red
                                    sortedItems.closingPrice?.toFloatOrNull() ?: 0f <= sortedItems.monthlyAveragePrice?.toFloatOrNull() ?: 0f -> Color.Green
                                    else -> Color.Black
                                }
                            )
                        }
                    }

                    // 最高價與最低價
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(Modifier.weight(1.0f)) {} // 空白占位
                        Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {
                            Text("最高價", fontSize = 12.sp, textAlign = TextAlign.Left)
                        }
                        Box(Modifier.weight(2.0f), contentAlignment = Alignment.Center) {
                            Text(
                                sortedItems.highestPrice ?: "沒有資料",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                        Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {
                            Text("最低價", fontSize = 12.sp, textAlign = TextAlign.Left)
                        }
                        Box(Modifier.weight(2.0f), contentAlignment = Alignment.Center) {
                            Text(
                                sortedItems.lowestPrice ?: "沒有資料",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    // 漲跌價差與月平均價
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(Modifier.weight(1.0f)) {} // 空白占位
                        Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {
                            Text("漲跌價差", fontSize = 12.sp, textAlign = TextAlign.Left)
                        }
                        // 根據漲跌價差的正負設定顏色
                        Box(Modifier.weight(2.0f), contentAlignment = Alignment.Center) {
                            Text(
                                text = sortedItems.change ?: "沒有資料",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Center,
                                color = when {
                                    sortedItems.change?.toFloatOrNull() ?: 0f >= 0 -> Color.Red
                                    sortedItems.change?.toFloatOrNull() ?: 0f < 0 -> Color.Green
                                    else -> Color.Black
                                }
                            )
                        }
                        Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {
                            Text("月平均價", fontSize = 12.sp, textAlign = TextAlign.Left)
                        }
                        Box(Modifier.weight(2.0f), contentAlignment = Alignment.Center) {
                            Text(
                                sortedItems.monthlyAveragePrice ?: "沒有資料",
                                fontSize = 15.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    Row { Box(Modifier.size(0.dp, 10.dp)) } // 調整 Card 內部間距

                    // 成交數據
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(Modifier.weight(2.0f), contentAlignment = Alignment.Center) {
                            Text("成交筆數", fontSize = 10.sp, textAlign = TextAlign.Left)
                        }
                        Box(Modifier.weight(2.0f), contentAlignment = Alignment.Center) {
                            Text(
                                sortedItems.tradeVolume ?: "沒有資料",
                                fontSize = 10.sp,
                                textAlign = TextAlign.Left
                            )
                        }
                        Box(Modifier.weight(0.5f)) {} // 空白占位
                        Box(Modifier.weight(2.0f), contentAlignment = Alignment.Center) {
                            Text("成交股數", fontSize = 10.sp, textAlign = TextAlign.Left)
                        }
                        Box(Modifier.weight(2.0f), contentAlignment = Alignment.Center) {
                            Text(
                                sortedItems.transaction ?: "沒有資料",
                                fontSize = 10.sp,
                                textAlign = TextAlign.Left
                            )
                        }
                        Box(Modifier.weight(0.5f)) {} // 空白占位
                        Box(Modifier.weight(2.0f), contentAlignment = Alignment.Center) {
                            Text("成交金額", fontSize = 10.sp, textAlign = TextAlign.Left)
                        }
                        Box(Modifier.weight(2.3f), contentAlignment = Alignment.Center) {
                            Text(
                                sortedItems.tradeValue ?: "沒有資料",
                                fontSize = 10.sp,
                                textAlign = TextAlign.Left
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.padding(4.dp)) // 在 Card 和其他元件間加間距
        }
    }

    LaunchedEffect(Unit) {
        viewModel.fetchReservoirInfoList()
    }
}
