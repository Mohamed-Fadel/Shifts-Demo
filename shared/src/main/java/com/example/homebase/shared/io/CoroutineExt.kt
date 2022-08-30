package com.example.homebase.shared.io

import com.github.michaelbull.result.Result
import com.github.michaelbull.result.fold
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onCompletion

fun <T> CoroutineScope.flowToUi(
    flow: Flow<T>,
    ui: (T) -> Unit,
    finally: () -> Unit = {},
    exception: ((Exception) -> Unit)? = null,
    timeout: Long? = null
): Job {
    return launch(Dispatchers.IO) {
        if (timeout == null) {
            collectFlow(flow, ui, finally, exception)
        } else {
            withTimeout(timeout) {
                collectFlow(flow, ui, finally, exception)
            }
        }
    }
}

private suspend fun <T> collectFlow(
    flow: Flow<T>,
    ui: (T) -> Unit,
    finally: () -> Unit = {},
    exception: ((Exception) -> Unit)? = null,
) {
    try {
        flow
            .onCompletion { finally.invoke() }.collect {
                withContext(Dispatchers.Main) {
                    ui(it)
                }
            }
    } catch (e: Exception) {
        withContext(Dispatchers.Main) {
            exception?.invoke(e)
        }
    }
}

fun CoroutineScope.io(
    io: suspend () -> Unit,
    exception: ((Exception) -> Unit)? = null
): Job {
    return launch(Dispatchers.Main) {
        withContext(Dispatchers.IO) {
            try {
                io()
            } catch (e: Exception) {
                exception?.invoke(e)
            }
        }
    }
}

fun <T, E> CoroutineScope.ioToResult(
    io: suspend () -> Result<T, E>,
    success: (T) -> Unit,
    error: (E) -> Unit,
    exception: ((Exception) -> Unit)? = null
): Job {
    return launch(Dispatchers.IO) {
        try {
            val result = io()
            withContext(Dispatchers.Main) {
                result.fold(success, error)
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                exception?.invoke(e)
            }
        }
    }
}