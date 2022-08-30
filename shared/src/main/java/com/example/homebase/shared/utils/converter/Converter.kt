package com.example.homebase.shared.utils.converter

/**
 * Interface for blocking conversion. Used for simple mapping.
 * */
interface Converter<S, T> {

    operator fun invoke(source: S): T
}
