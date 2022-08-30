package com.example.homebase.domain.usecase

abstract class UseCase<T> {

    abstract suspend fun execute(): T
}