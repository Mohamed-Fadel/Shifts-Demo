package com.example.homebase.feature_shifts.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.feature_shifts_domain.domain.usecase.GetShiftsUseCase
import com.example.feature_shifts_domain.entity.Shift
import com.example.homebase.feature_shifts.ui.utils.Destination
import com.example.homebase.shared.ui.extensions.flowToUi
import com.example.homebase.shared.utils.Event
import com.github.michaelbull.result.fold

class ShiftsViewModel(
    private val getShiftsUseCase: GetShiftsUseCase
) : ViewModel() {

    private val _navigateTo = MutableLiveData<Event<Destination>>()
    val navigateTo: LiveData<Event<Destination>> = _navigateTo

    private val _shiftsList = MutableLiveData<List<Shift>>()
    val shiftsList: LiveData<List<Shift>> = _shiftsList

    fun onScreenStarted() {
        flowToUi(
            flow = getShiftsUseCase.execute(),
            ui = { result ->
                result.fold(
                    success = {
                        _shiftsList.postValue(it)
                    },
                    failure = {
                        TODO("Not Implemented")
                    }
                )
            },
            exception = {
                TODO("Not Implemented")
            }
        )
    }

    fun onAddButtonClicked() {
        _navigateTo.postValue(Event(Destination.ADD_SHIFT))
    }
}