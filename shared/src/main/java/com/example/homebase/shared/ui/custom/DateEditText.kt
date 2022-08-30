package com.example.homebase.shared.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.FragmentManager
import com.example.homebase.shared.utils.ext.YYYY_MM_DD_FORAMT
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat

class DateEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatEditText(context, attrs, defStyle) {

    private val datePicker: MaterialDatePicker<Long>

    init {
        isFocusable = false
        isClickable = true

        gravity = Gravity.CENTER_VERTICAL

        datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select a day")
            .build()

        datePicker.addOnPositiveButtonClickListener {
            setText(SimpleDateFormat(YYYY_MM_DD_FORAMT).format(it))
        }

    }

    fun show(manager: FragmentManager, tag: String? = null) {
        datePicker.show(manager, tag)
    }

    fun addOnPositiveButtonClickListener(onPositiveButtonClickListener: (timeMillis: Long) -> Unit) {
        datePicker.addOnPositiveButtonClickListener {
            onPositiveButtonClickListener.invoke(it)
        }
    }
}