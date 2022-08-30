package com.example.feature_shifts_domain.data.repository

import com.example.feature_shifts_domain.data.source.BootstrapShiftsDataSource
import com.example.feature_shifts_domain.domain.repository.ShiftsRepository
import com.example.feature_shifts_domain.entity.Shift
import com.example.homebase.domain.errorhandling.Error
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.onSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class ShiftsRepositoryImp(
    private val bootstrapShiftsDataSource: BootstrapShiftsDataSource
) : ShiftsRepository {

    private val _shiftsMemCache by lazy {
        MutableStateFlow(bootstrapShiftsDataSource.fetchLocalShiftss())
    }

    override fun retrieveShifts(): Flow<Result<List<Shift>, Error>> {
        return _shiftsMemCache
    }

    override suspend fun addShift(shift: Shift): Result<Unit, Error> {
        _shiftsMemCache.value.onSuccess {
            _shiftsMemCache.emit(
                Ok(
                    mutableListOf(
                        shift,
                        *it.toTypedArray()
                    )
                )
            )
        }
        return Ok(Unit)
    }
}