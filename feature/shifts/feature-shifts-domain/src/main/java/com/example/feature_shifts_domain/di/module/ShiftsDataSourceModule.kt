package com.example.feature_shifts_domain.di.module

import com.example.feature_shifts_domain.data.source.BootstrapShiftsDataSource
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val shiftsDataSourceModule = module {
    factoryOf(::BootstrapShiftsDataSource)
}
