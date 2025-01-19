package com.hi.interviewstock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hi.interviewstock.presentation.view.StockScreen
import com.hi.interviewstock.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme(dynamicColor = false) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {
                        StockScreen("升")
                    }


                }
            }
        }
    }
}