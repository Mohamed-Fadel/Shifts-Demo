package com.example.homebase.shared.ui.extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homebase.shared.io.flowToUi
import com.example.homebase.shared.io.ioToResult
import com.github.michaelbull.result.Result
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow

fun <T> ViewModel.flowToUi(
    flow: Flow<T>,
    ui: (T) -> Unit,
    exception: ((Exception) -> Unit)? = null,
    finally: () -> Unit = {},
    timeout: Long? = null
): Job = viewModelScope.flowToUi(flow, ui, finally, exception, timeout)

fun <T, E> ViewModel.ioToResult(
    io: suspend () -> Result<T, E>,
    success: (T) -> Unit,
    error: (E) -> Unit,
    exception: ((Exception) -> Unit)? = null
): Job = viewModelScope.ioToResult(io, success, error, exception)