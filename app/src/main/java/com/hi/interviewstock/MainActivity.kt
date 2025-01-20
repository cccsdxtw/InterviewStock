package com.hi.interviewstock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hi.interviewstock.presentation.view.StockScreen
import com.hi.interviewstock.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

// 使用 Hilt 來進行依賴注入
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 設定 Composable UI
        setContent {
            // 使用自訂的主題，並關閉動態色彩
            MyApplicationTheme(dynamicColor = false) {

                // 背景顏色額外設定
                val backgroundColor = if (isSystemInDarkTheme()) {
                    Color(0xFF212121)
                } else {
                    Color(0xFFFFFFFF)
                }

                //主要UI
                Column(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        Modifier
                            .background(backgroundColor)
                            .weight(1.0f),
                        contentAlignment = Alignment.Center
                    ) {
                        //  StockScreen "降冪"做預設
                        StockScreen("降")
                    }
                }
            }
        }
    }
}
