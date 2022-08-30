package com.example.homebase.feature_shifts.di.module

import com.example.homebase.feature_shifts.converter.ShiftParamToShiftConverter
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val shiftsConverterModule = module {
    factoryOf(::ShiftParamToShiftConverter)
}
