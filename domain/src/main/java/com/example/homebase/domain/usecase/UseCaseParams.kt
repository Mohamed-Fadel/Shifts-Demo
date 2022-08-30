package com.example.homebase.domain.usecase

import androidx.annotation.WorkerThread

abstract class UseCaseParams<T, Params> {

    @WorkerThread
    abstract suspend fun execute(params: Params): T
}
