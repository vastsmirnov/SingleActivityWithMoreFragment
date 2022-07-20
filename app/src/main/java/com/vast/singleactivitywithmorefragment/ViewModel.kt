package com.vast.singleactivitywithmorefragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel(val count: Int): ViewModel() {
    private val _navigateCounterLiveData: MutableLiveData<Int> = MutableLiveData(0)

    val navigateCounterLiveData = _navigateCounterLiveData as LiveData<Int>

    init {
        _navigateCounterLiveData.value = count
    }
}
