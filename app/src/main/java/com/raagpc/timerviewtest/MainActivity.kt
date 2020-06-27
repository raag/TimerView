package com.raagpc.timerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.raagpc.timerview.TimerView

class MainActivity : AppCompatActivity() {

    private lateinit var forwardTimer: TimerView
    private lateinit var backwardTimer: TimerView
    private lateinit var forwardStatus: TextView
    private lateinit var backwardStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forwardTimer = findViewById(R.id.forwardTimer)
        backwardTimer = findViewById(R.id.backwardTimer)
        forwardStatus = findViewById(R.id.forward_status)
        backwardStatus = findViewById(R.id.backward_status)

        forwardTimer.setTimerViewListener(forwardListener)
        // backwardTimer.setTimerViewListener(backwardListener)

        backwardTimer.start()
        forwardTimer.start()

    }

    private val forwardListener = object: TimerView.TimerViewListener {
        override fun onTick(time: Int) {
            forwardStatus.text = "Time to finish: $time"
        }

        override fun onFinish() {
            forwardStatus.text = "count finished!"
        }
    }

    private val backwardListener = object: TimerView.TimerViewListener {
        override fun onTick(time: Int) {
            backwardStatus.text = "Remaining time: $time"
        }

        override fun onFinish() {
            backwardStatus.text = "countdown finished!"
        }
    }
}