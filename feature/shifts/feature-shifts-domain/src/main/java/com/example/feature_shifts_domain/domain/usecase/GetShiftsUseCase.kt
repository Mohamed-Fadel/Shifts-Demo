package com.example.feature_shifts_domain.domain.usecase

import com.example.feature_shifts_domain.domain.repository.ShiftsRepository
import com.example.feature_shifts_domain.entity.Shift
import com.example.homebase.domain.errorhandling.Error
import com.example.homebase.domain.usecase.FlowUseCase
import com.example.homebase.domain.usecase.UseCase
import com.github.michaelbull.result.Result
import kotlinx.coroutines.flow.Flow

class GetShiftsUseCase(
    private val shiftsRepository: ShiftsRepository
) : FlowUseCase<Flow<Result<List<Shift>, Error>>>() {

    override fun execute() = shiftsRepository.retrieveShifts()
}