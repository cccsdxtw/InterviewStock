package com.hi.interviewstock

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.Observer
import com.hi.interviewstock.presentation.view.StockScreen
import com.hi.interviewstock.presentation.viewmodel.StockViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val stockViewModel: StockViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column(modifier = Modifier.fillMaxWidth()) {
                Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {
                    StockScreen("升")
                }
//                Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {
//                    BwlbbuAllScreen()
//                }
//                Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {
//                    StockDayAllScreen()
//                }
//                Box(Modifier.weight(1.0f), contentAlignment = Alignment.Center) {
//                    StockDayAvgAllcreen()
//                }


            }
        }
    }
}