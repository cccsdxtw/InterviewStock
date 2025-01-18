package com.hi.interviewstock.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hi.interviewstock.data.repository.BwibbuAllRepository
import com.hi.interviewstock.domain.model.BwibbuAllInfoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BwibbuAllViewModel @Inject constructor(
    private val repository: BwibbuAllRepository
) : ViewModel() {

    private val _reservoirInfoList = MutableStateFlow<List<BwibbuAllInfoItem>>(emptyList())
    val reservoirInfoList: StateFlow<List<BwibbuAllInfoItem>> get() = _reservoirInfoList

    fun fetchReservoirInfoList() {
        viewModelScope.launch {
            val result = repository.fetchReservoirInfoList()
            _reservoirInfoList.value = result
        }
    }
}
