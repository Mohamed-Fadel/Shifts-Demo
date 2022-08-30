package com.example.homebase.shared.utils

import androidx.lifecycle.Observer

class EventObserver<T>(private val onChange: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(t: Event<T>?) {
        t?.getContentIfNotHandled()?.run {
            onChange.invoke(this)
        }
    }
}
