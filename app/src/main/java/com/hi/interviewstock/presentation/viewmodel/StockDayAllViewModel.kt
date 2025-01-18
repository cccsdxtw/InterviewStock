package com.hi.interviewstock.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hi.interviewstock.data.repository.StockDayAllRepository
import com.hi.interviewstock.domain.model.StockDayAllInfoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockDayAllViewModel @Inject constructor(
    private val repository: StockDayAllRepository
) : ViewModel() {

    private val _reservoirInfoList = MutableStateFlow<List<StockDayAllInfoItem>>(emptyList())
    val reservoirInfoList: StateFlow<List<StockDayAllInfoItem>> get() = _reservoirInfoList

    fun fetchReservoirInfoList() {
        viewModelScope.launch {
            val result = repository.fetchReservoirInfoList()
            _reservoirInfoList.value = result
        }
    }
}
