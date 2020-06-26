package com.raagpc.timerview

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewViewModel(private val maxValue: Int, private val initialValue: Int, private val isBackward: Boolean = false) : ViewModel() {

    private lateinit var timer: CountDownTimer
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
        timer.start()
    }

    private fun initCountForward() {
        val maxValue = maxValue.toLong() * 1000
        timer = object : CountDownTimer(maxValue, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val remainingTime:Int = (maxValue / 1000).toInt() - (millisUntilFinished / 1000).toInt()
                value.postValue(remainingTime)
            }
            override fun onFinish() {
                finished.postValue(true)
            }
        }
        timer.start()
    }

}