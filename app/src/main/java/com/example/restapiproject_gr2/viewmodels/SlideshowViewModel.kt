package com.example.restapiproject_gr2.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {
    val count : MutableLiveData<Int> = MutableLiveData(0)


}