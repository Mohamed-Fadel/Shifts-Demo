package com.example.homebase.feature_shifts.converter

import com.example.feature_shifts_domain.entity.Shift
import com.example.homebase.feature_shifts.ui.viewmodel.ShiftParams
import com.example.homebase.shared.utils.converter.Converter
import com.example.homebase.shared.utils.ext.YYYYMMDDHHmm_FORMAT
import org.threeten.bp.LocalDateTime

class ShiftParamToShiftConverter : Converter<ShiftParams, Shift> {
    override fun invoke(source: ShiftParams): Shift {
        with(source) {
            val startDateString = "$startDate $startTime"
            val endDateString = "$startDate $endTime"

            return Shift(
                role = roleWrapper.role,
                name = employee,
                startDate = LocalDateTime.parse(startDateString, YYYYMMDDHHmm_FORMAT),
                endDate = LocalDateTime.parse(endDateString, YYYYMMDDHHmm_FORMAT),
                color = colorWrapper.color
            )
        }

    }
}