package com.rezoo.kotlinflows

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow

class MainViewModel:ViewModel() {
    val countDownFlow = flow<Int> {
        val startingValue= 10
        var currentValue=startingValue
        emit(startingValue)
        while (currentValue>0){
            delay(1000L)
            currentValue--
            emit(currentValue)

        }
    }

    private val _stateFlow= MutableStateFlow(0)
    val stateFlow = _stateFlow.asStateFlow()
    fun incrementCounter(){
        _stateFlow.value+=1
    }

}