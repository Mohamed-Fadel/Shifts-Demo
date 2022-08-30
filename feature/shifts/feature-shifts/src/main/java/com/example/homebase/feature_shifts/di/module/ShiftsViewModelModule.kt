package com.example.homebase.feature_shifts.di.module

import com.example.homebase.feature_shifts.ui.viewmodel.AddShiftViewModel
import com.example.homebase.feature_shifts.ui.viewmodel.ShiftsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val shiftsViewModelModule = module {
    viewModelOf(::ShiftsViewModel)
    viewModelOf(::AddShiftViewModel)
}
