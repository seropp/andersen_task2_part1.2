package com.example.andersentask2p1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var nmbLiveData = MutableLiveData(0)

    fun setData() {
        val count: Int = if (nmbLiveData.value != null) nmbLiveData.value!! else 0
        nmbLiveData.value = count + 1
    }

    fun getLiveData(): MutableLiveData<Int> {
        return nmbLiveData
    }

    fun zeroLiveData(){
        nmbLiveData.value = 0
    }
}