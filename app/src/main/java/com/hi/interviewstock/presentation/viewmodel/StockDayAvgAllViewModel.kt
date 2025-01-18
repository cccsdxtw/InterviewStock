package com.hi.interviewstock.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hi.interviewstock.data.repository.StockDayAvgAllRepository
import com.hi.interviewstock.domain.model.StockDayAvgAllInfoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockDayAvgAllViewModel @Inject constructor(
    private val repository: StockDayAvgAllRepository
) : ViewModel() {

    private val _reservoirInfoList = MutableStateFlow<List<StockDayAvgAllInfoItem>>(emptyList())
    val reservoirInfoList: StateFlow<List<StockDayAvgAllInfoItem>> get() = _reservoirInfoList

    fun fetchReservoirInfoList() {
        viewModelScope.launch {
            val result = repository.fetchReservoirInfoList()
            _reservoirInfoList.value = result
        }
    }
}
