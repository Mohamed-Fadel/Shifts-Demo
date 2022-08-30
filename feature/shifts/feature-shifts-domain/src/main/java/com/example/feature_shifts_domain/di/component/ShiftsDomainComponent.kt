package com.example.feature_shifts_domain.di.component

import com.example.feature_shifts_domain.di.module.shiftsDataSourceModule
import com.example.feature_shifts_domain.di.module.shiftsRepositoryModule
import com.example.feature_shifts_domain.di.module.shiftsUseCaseModule

object ShiftsDomainComponent {

    fun getAllModules() = arrayOf(
        shiftsDataSourceModule,
        shiftsRepositoryModule,
        shiftsUseCaseModule
    )
}
