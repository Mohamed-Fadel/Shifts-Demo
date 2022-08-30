package com.example.homebase.shared.di.module

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val sharedModule = module {
    single { androidContext().resources }
}