package com.raagpc.timerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.raagpc.timerview.TimerView

class MainActivity : AppCompatActivity() {
    private lateinit var backwardTimer: TimerView
    private lateinit var backwardStatus: TextView
    private lateinit var toggleButton: Button
    private lateinit var resetButton: Button
    private var running = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backwardTimer = findViewById(R.id.backwardTimer)
        backwardStatus = findViewById(R.id.backward_status)
        toggleButton = findViewById(R.id.toggle_button)
        resetButton = findViewById(R.id.reset_button)

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
            backwardTimer.start()
        } else {
            backwardTimer.pause()
        }
        running = !running
    }

    private fun reset() {
        backwardTimer.stop()
        running = false
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