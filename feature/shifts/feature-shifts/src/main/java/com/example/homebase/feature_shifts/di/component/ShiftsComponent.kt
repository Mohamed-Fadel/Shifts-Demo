package com.example.homebase.feature_shifts.di.component

import com.example.homebase.feature_shifts.di.module.shiftsConverterModule
import com.example.homebase.feature_shifts.di.module.shiftsViewModelModule

object ShiftsComponent {

    fun getAllModules() = arrayOf(
        shiftsViewModelModule,
        shiftsConverterModule
    )
}
