package com.raagpc.timerview

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewViewModel(private var maxValue: Int, private var initialValue: Int, private var isBackward: Boolean = false) : ViewModel() {

    private var timer: CountDownTimer? = null
    val value = MutableLiveData<Int>()
    val finished = MutableLiveData<Boolean>()

    fun startTimer() {
        finished.postValue(false)
        if (isBackward) {
            initCountDown()
        } else {
            initCountForward()
        }
    }

    fun setMaxValue(maxValue: Int) {
        this.maxValue = maxValue
    }

    fun setInitialValue(initialValue: Int) {
        this.initialValue = initialValue
        value.postValue(initialValue)
    }

    fun setIsBackward(isBackward: Boolean) {
        this.isBackward = isBackward
    }

    private fun initCountDown() {
        val initialValue = initialValue.toLong() * 1000
        timer = object : CountDownTimer(initialValue, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val remainingTime:Int = (millisUntilFinished / 1000).toInt()
                value.postValue(remainingTime)
            }
            override fun onFinish() {
                finished.postValue(true)
            }
        }
        timer?.start()
    }

    fun pause() {
        timer?.cancel()
    }

    fun stop() {
        initialValue = if (isBackward) {
            maxValue
        } else {
            0
        }

        value.postValue(initialValue)

        timer?.cancel()
    }

    private fun initCountForward() {
        val maxValue = maxValue.toLong() * 1000
        val initialValue = initialValue.toLong() * 1000
        timer = object : CountDownTimer(maxValue - initialValue, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val remainingTime:Int = (maxValue / 1000).toInt() - (millisUntilFinished / 1000).toInt()
                value.postValue(remainingTime)
            }
            override fun onFinish() {
                finished.postValue(true)
            }
        }
        timer?.start()
    }

}