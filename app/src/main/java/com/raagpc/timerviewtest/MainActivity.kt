package com.raagpc.timerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.raagpc.timerview.TimerView

class MainActivity : AppCompatActivity() {

    private lateinit var forwardTimer: TimerView
    private lateinit var backwardTimer: TimerView
    private lateinit var forwardStatus: TextView
    private lateinit var backwardStatus: TextView
    private lateinit var toggleButton: Button
    private lateinit var resetButton: Button
    private var running = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forwardTimer = findViewById(R.id.forwardTimer)
        backwardTimer = findViewById(R.id.backwardTimer)
        forwardStatus = findViewById(R.id.forward_status)
        backwardStatus = findViewById(R.id.backward_status)
        toggleButton = findViewById(R.id.toggle_button)
        resetButton = findViewById(R.id.reset_button)

        forwardTimer.setTimerViewListener(forwardListener)
        backwardTimer.setTimerViewListener(backwardListener)

        toggleButton.setOnClickListener {
            toggle()
        }

        resetButton.setOnClickListener {
            reset()
        }
    }

    private fun toggle() {
        if (!running) {
            forwardTimer.start()
            backwardTimer.start()
        } else {
            forwardTimer.pause()
            backwardTimer.pause()
        }
        running = !running
    }

    private fun reset() {
        backwardTimer.stop()
        forwardTimer.stop()
        running = false
    }

    private val forwardListener = object: TimerView.TimerViewListener {
        override fun onTick(time: Int, timerView: TimerView) {
            forwardStatus.text = "Time to finish: $time"
        }

        override fun onFinish(timerView: TimerView) {
            forwardStatus.text = "count finished!"
        }
    }

    private val backwardListener = object: TimerView.TimerViewListener {
        override fun onTick(time: Int, timerView: TimerView) {
            backwardStatus.text = "Remaining time: $time"
        }

        override fun onFinish(timerView: TimerView) {
            backwardStatus.text = "countdown finished!"
        }
    }
}