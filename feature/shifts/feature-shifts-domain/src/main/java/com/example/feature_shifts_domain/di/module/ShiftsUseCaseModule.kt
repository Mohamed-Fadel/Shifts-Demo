package com.example.feature_shifts_domain.di.module

import com.example.feature_shifts_domain.domain.usecase.AddNewShiftUseCase
import com.example.feature_shifts_domain.domain.usecase.GetShiftsUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val shiftsUseCaseModule = module {
    factoryOf(::GetShiftsUseCase)
    factoryOf(::AddNewShiftUseCase)
}
