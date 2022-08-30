package com.example.homebase.shared.ui.custom

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.homebase.shared.utils.ext.EEE_FORMAT
import com.example.homebase.shared.utils.ext.MMM_FORMAT
import com.example.homebase.shared.utils.ext.d_FORMAT
import org.threeten.bp.LocalDateTime

class DayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatTextView(context, attrs, defStyle) {

    fun setDate(dateTime: LocalDateTime) {
        val spannableString = SpannableString(dateTime.d_FORMAT)
        spannableString.setSpan(
            AbsoluteSizeSpan(28, true),
            0,
            spannableString.length,
            Spannable.SPAN_POINT_MARK
        )

        val spannableStringBuilder = SpannableStringBuilder()
        spannableStringBuilder.append(dateTime.MMM_FORMAT.uppercase())
        spannableStringBuilder.append("\n")
        spannableStringBuilder.append(spannableString)
        spannableStringBuilder.append("\n")
        spannableStringBuilder.append(dateTime.EEE_FORMAT.uppercase())
        text = spannableStringBuilder
    }
}