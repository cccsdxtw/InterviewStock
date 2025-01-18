package com.hi.interviewstock.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hi.interviewstock.data.repository.BWIBBUALLRepository
import com.hi.interviewstock.domain.model.BWIBBUALLInfoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BWIBBUALLViewModel @Inject constructor(
    private val repository: BWIBBUALLRepository
) : ViewModel() {

    private val _reservoirInfoList = MutableStateFlow<List<BWIBBUALLInfoItem>>(emptyList())
    val reservoirInfoList: StateFlow<List<BWIBBUALLInfoItem>> get() = _reservoirInfoList

    fun fetchReservoirInfoList() {
        viewModelScope.launch {
            val result = repository.fetchReservoirInfoList()
            _reservoirInfoList.value = result
        }
    }
}
