package com.example.homebase.data.di.component

import com.example.homebase.data.di.module.dataModule

object DataComponent {
    fun getAllModules() = arrayOf(
        dataModule
    )
}