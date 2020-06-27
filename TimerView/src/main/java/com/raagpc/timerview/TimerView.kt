package com.raagpc.timerview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity

class TimerView(context: Context, attrs: AttributeSet): androidx.appcompat.widget.AppCompatTextView(context, attrs) {

    interface TimerViewListener {
        fun onTick(time: Int)
        fun onFinish()
    }

    private val maxValue: Int
    private var value: Int
    private val colorPrimary: Int
    private val colorSecondary: Int
    private val isBackward: Boolean

    private val timerPadding: Int
    private val strokeWidth: Float
    private val viewModel: TimerViewViewModel
    private var listener: TimerViewListener? = null

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TimerView,
            0, 0).apply {

            try {
                colorPrimary = getColor(R.styleable.TimerView_colorPrimary, -0x000000)
                colorSecondary = getColor(R.styleable.TimerView_colorSecondary, -0x999999)
                timerPadding = getInteger(R.styleable.TimerView_timerPadding, 5)
                strokeWidth = getFloat(R.styleable.TimerView_timerStrokeWidth, 20F)
                isBackward = getBoolean(R.styleable.TimerView_isBackward, false)
                maxValue = getInteger(R.styleable.TimerView_maxValue, 100)

                val defaultValue = if (isBackward) {
                    maxValue
                } else {
                    0
                }

                value = getInteger(R.styleable.TimerView_value, defaultValue)
                gravity = Gravity.CENTER
                text = value.toString()
                setTypeface(null, Typeface.BOLD)
                setTextColor(colorPrimary)
            } finally {
                recycle()
            }

            viewModel = TimerViewViewModel(maxValue, value, isBackward)
            setupObservers()
        }
    }

    private fun setupObservers() {
        viewModel.value.observeForever {
            this.setValue(it)
            listener?.onTick(it)
        }

        viewModel.finished.observeForever {
            if (it) {
                listener?.onFinish()
            }
        }
    }

    fun start() {
        viewModel.startTimer()
    }

    override fun onDraw(canvas: Canvas?) {
        val width = width.toFloat()
        val height = height.toFloat()

        val radius: Float

        radius = if (width > height) {
            (height / 3) - timerPadding
        } else {
            (width / 3) - timerPadding
        }

        val paint = Paint()
        paint.isAntiAlias = true
        paint.color = colorPrimary
        paint.strokeWidth = strokeWidth

        paint.style = Paint.Style.STROKE

        val centerX: Float = width / 2
        val centerY: Float = height / 2

        val left = centerX - radius
        val top: Float = centerY - radius
        val right = centerX + radius
        val bottom: Float = centerY + radius

        val oval = RectF()
        oval.set(left, top, right, bottom)

        val degrees = ((value * 360) / maxValue).toFloat()

        canvas?.let {
            it.drawArc(oval, 0f, 360f, false, paint)
            paint.color = colorSecondary
            it.drawArc(oval, 0f, 360f - degrees , false, paint)
        }

        super.onDraw(canvas)
    }

    fun setValue(countdown: Int) {
        this.value = countdown
        this.text = countdown.toString()
        invalidate()
        requestLayout()
    }

    fun getValue(): Int {
        return value
    }

    fun setTimerViewListener(listener: TimerViewListener) {
        this.listener = listener
    }
}