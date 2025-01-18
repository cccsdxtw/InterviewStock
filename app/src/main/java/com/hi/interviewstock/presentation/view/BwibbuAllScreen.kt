package com.hi.interviewstock.presentation.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hi.interviewstock.presentation.viewmodel.BwibbuAllViewModel


@Composable
fun BWIBBUALLScreen(viewModel: BwibbuAllViewModel = hiltViewModel()) {
    val items = viewModel.reservoirInfoList.collectAsState(initial = emptyList())

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(items.value.size) { index ->
            val item = items.value[index]
            Column(Modifier.padding(8.dp)) {
                BasicText("Code: ${item.Code}")
                BasicText("Name: ${item.Name}")
                BasicText("Yield Rate: ${item.DividendYield}")
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.fetchReservoirInfoList()
    }
}
