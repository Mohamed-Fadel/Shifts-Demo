package com.example.homebase.domain.usecase

abstract class FlowUseCase<T> {

    abstract fun execute(): T
}