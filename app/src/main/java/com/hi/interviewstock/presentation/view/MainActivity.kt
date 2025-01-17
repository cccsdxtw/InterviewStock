package com.hi.interviewstock.presentation.view

import GreetingViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hi.interviewstock.theme.InterviewStockTheme
import androidx.lifecycle.compose.collectAsStateWithLifecycle


class MainActivity : ComponentActivity() {
    private val greetingViewModel: GreetingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterviewStockTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(greetingViewModel = greetingViewModel, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(greetingViewModel: GreetingViewModel, modifier: Modifier = Modifier) {
    // 使用 collectAsStateWithLifecycle 來觀察 LiveData 並轉換為 State
    val greetingMessage by greetingViewModel.greetingMessage.collectAsStateWithLifecycle("")

    // 顯示 greeting 訊息
    Text(text = greetingMessage, modifier = modifier)

    // 假設某些情況下改變問候語
    LaunchedEffect(Unit) {
        greetingViewModel.updateGreeting("Jetpack Compose")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InterviewStockTheme {
        Greeting(greetingViewModel = GreetingViewModel())
    }
}
