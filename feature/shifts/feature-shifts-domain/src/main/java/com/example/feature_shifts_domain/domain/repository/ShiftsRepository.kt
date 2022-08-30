package com.example.feature_shifts_domain.domain.repository

import com.example.feature_shifts_domain.entity.Shift
import com.example.homebase.domain.errorhandling.Error
import com.github.michaelbull.result.Result
import kotlinx.coroutines.flow.Flow

interface ShiftsRepository {

    fun retrieveShifts(): Flow<Result<List<Shift>, Error>>
    suspend fun addShift(shift: Shift): Result<Unit, Error>
}