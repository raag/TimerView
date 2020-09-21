package com.raagpc.timerview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TimerViewViewModelFactory(
    private var maxValue: Int,
    private var initialValue: Int,
    private var isBackward: Boolean = false
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TimerViewViewModel(
            maxValue,
            initialValue,
            isBackward
        ) as T
    }
}