package com.hi.interviewstock.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hi.interviewstock.data.repository.BwlbbuAllRepository
import com.hi.interviewstock.domain.model.BwlbbuAllInfoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BwlbbuAllViewModel @Inject constructor(
    private val repository: BwlbbuAllRepository
) : ViewModel() {

    private val _reservoirInfoList = MutableStateFlow<List<BwlbbuAllInfoItem>>(emptyList())
    val reservoirInfoList: StateFlow<List<BwlbbuAllInfoItem>> get() = _reservoirInfoList

    fun fetchReservoirInfoList() {
        viewModelScope.launch {
            val result = repository.fetchReservoirInfoList()
            _reservoirInfoList.value = result
        }
    }
}
