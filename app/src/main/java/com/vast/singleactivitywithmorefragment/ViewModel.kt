package com.vast.singleactivitywithmorefragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel(val count: Int): ViewModel() {
    private val _liveData: MutableLiveData<Int> = MutableLiveData(0)

    val liveData = _liveData as LiveData<Int>

    init {
        _liveData.value = count
    }
}
