package com.example.homebase.feature_shifts.ui.viewmodel

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.feature_shifts_domain.domain.usecase.AddNewShiftUseCase
import com.example.feature_shifts_domain.domain.usecase.GetShiftsUseCase
import com.example.feature_shifts_domain.entity.Color
import com.example.feature_shifts_domain.entity.Role
import com.example.homebase.feature_shifts.R
import com.example.homebase.feature_shifts.converter.ShiftParamToShiftConverter
import com.example.homebase.feature_shifts.ui.utils.Destination
import com.example.homebase.shared.ui.extensions.flowToUi
import com.example.homebase.shared.ui.extensions.ioToResult
import com.example.homebase.shared.utils.Event
import com.github.michaelbull.result.fold

data class RoleWrapper(val role: Role, val string: String) {
    override fun toString() = string
}

data class ColorWrapper(val color: Color, val string: String) {
    override fun toString() = string
}

class AddShiftViewModel(
    private val resources: Resources,
    private val getShiftsUseCase: GetShiftsUseCase,
    private val addNewShiftUseCase: AddNewShiftUseCase,
    private val shiftParamToShiftConverter: ShiftParamToShiftConverter
) : ViewModel() {
    private val _employees = MutableLiveData<List<String>>()
    val employees: LiveData<List<String>> = _employees

    private val _roles = MutableLiveData<List<RoleWrapper>>()
    val roles: LiveData<List<RoleWrapper>> = _roles

    private val _colors = MutableLiveData<List<ColorWrapper>>()
    val colors: LiveData<List<ColorWrapper>> = _colors

    private val _navigateTo = MutableLiveData<Event<Destination>>()
    val navigateTo: LiveData<Event<Destination>> = _navigateTo

    private val _successMessage = MutableLiveData<Event<String>>()
    val successMessage: LiveData<Event<String>> = _successMessage

    fun onScreenStarted() {
        flowToUi(
            flow = getShiftsUseCase.execute(),
            ui = { result ->
                result.fold(
                    success = {
                        _employees.postValue(it.map {
                            it.name
                        }.distinctBy { it })
                        _roles.postValue(getRoles(resources))
                        _colors.postValue(getColors(resources))
                    },
                    failure = {
                        TODO()
                    }
                )
            },
            exception = {
                TODO()
            }
        )

    }

    fun onAddButtonClicked(params: ShiftParams) {
        val newShift = shiftParamToShiftConverter(params)
        ioToResult(
            io = {
                addNewShiftUseCase.execute(newShift)
            },
            success = { result ->
                _successMessage.value =
                    Event(resources.getString(R.string.message_shift_added_successfully))
                _navigateTo.postValue(Event(Destination.SHIFT_LIST))
            },
            error = {
                TODO()
            },
            exception = {
                TODO()
            }
        )
    }
}

fun getRoles(resources: Resources) = Role.values().map {
    RoleWrapper(it, resources.getString(it.resId))
}

fun getColors(resources: Resources) = Color.values().map {
    ColorWrapper(it, resources.getString(it.resId))
}

data class ShiftParams(
    val startDate: String,
    val startTime: String,
    val endTime: String,
    val employee: String,
    val roleWrapper: RoleWrapper,
    val colorWrapper: ColorWrapper
)