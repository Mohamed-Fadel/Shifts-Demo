package com.example.homebase.data.di.module

import com.example.homebase.data.adapter.LocalDateAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.dsl.module

val dataModule = module {

    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(LocalDateAdapter())
            .build()
    }
}