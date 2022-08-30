package com.example.feature_shifts_domain.di.module

import com.example.feature_shifts_domain.data.repository.ShiftsRepositoryImp
import com.example.feature_shifts_domain.domain.repository.ShiftsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val shiftsRepositoryModule = module {

    singleOf(::ShiftsRepositoryImp) bind ShiftsRepository::class
}
