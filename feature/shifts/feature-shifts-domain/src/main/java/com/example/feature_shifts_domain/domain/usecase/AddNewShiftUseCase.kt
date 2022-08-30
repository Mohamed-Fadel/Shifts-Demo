package com.example.feature_shifts_domain.domain.usecase

import com.example.feature_shifts_domain.domain.repository.ShiftsRepository
import com.example.feature_shifts_domain.entity.Shift
import com.example.homebase.domain.errorhandling.Error
import com.example.homebase.domain.usecase.UseCaseParams
import com.github.michaelbull.result.Result

class AddNewShiftUseCase(
    private val shiftsRepository: ShiftsRepository
) : UseCaseParams<Result<Unit, Error>, Shift>() {

    override suspend fun execute(params: Shift) = shiftsRepository.addShift(params)
}