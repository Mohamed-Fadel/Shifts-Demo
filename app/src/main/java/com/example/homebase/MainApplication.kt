package com.example.homebase

import android.app.Application
import com.example.feature_shifts_domain.di.component.ShiftsDomainComponent
import com.example.homebase.data.di.component.DataComponent
import com.example.homebase.feature_shifts.di.component.ShiftsComponent
import com.example.homebase.shared.di.component.SharedComponent
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()

        AndroidThreeTen.init(this)
    }

    @Suppress("SpreadOperator", "LongMethod")
    private fun initKoin() {
        startKoin {
            androidContext(this@MainApplication)

            val featureModules = arrayOf(
                *ShiftsComponent.getAllModules(),
                *ShiftsDomainComponent.getAllModules()
            )

            val dataModules = arrayOf(
                *DataComponent.getAllModules()
            )

            val sharedModules = arrayOf(
                *SharedComponent.getAllModules()
            )

            modules(
                *featureModules,
                *dataModules,
                *sharedModules
            )
        }
    }

}