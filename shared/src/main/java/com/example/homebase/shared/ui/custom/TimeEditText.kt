package com.example.homebase.shared.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.FragmentManager
import com.google.android.material.timepicker.MaterialTimePicker

class TimeEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatEditText(context, attrs, defStyle) {

    private val timePicker: MaterialTimePicker

    init {
        isFocusable = false
        isClickable = true

        gravity = Gravity.CENTER_VERTICAL

        timePicker = MaterialTimePicker.Builder()
            .setTitleText("Select a time")
            .build()

        timePicker.addOnPositiveButtonClickListener {
            setText(String.format("%02d:%02d", timePicker.hour, timePicker.minute))
        }
    }

    fun show(manager: FragmentManager, tag: String? = null) {
        timePicker.show(manager, tag)
    }

    fun addOnPositiveButtonClickListener(onPositiveButtonClickListener: (hour: Int, minute: Int) -> Unit) {
        timePicker.addOnPositiveButtonClickListener {
            onPositiveButtonClickListener.invoke(timePicker.hour, timePicker.minute)
        }
    }
}