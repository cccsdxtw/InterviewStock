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

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme(dynamicColor = false) {
                // 根據系統主題決定背景顏色
                val backgroundColor = if (isSystemInDarkTheme()) {
                    Color(0xFF212121)
                } else {
                    Color(0xFFFFFFFF)
                }

                Column(modifier = Modifier.fillMaxWidth()) {
                    Box(Modifier .background(backgroundColor).weight(1.0f), contentAlignment = Alignment.Center) {
                        StockScreen("升")
                    }
                }
            }
        }
    }
}