package com.abuffseagull.tannustemplate

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val currentSet = MutableLiveData<Int>().apply { value = 1 }
    val maxSet = MutableLiveData<Int>().apply { value = 5 }
}