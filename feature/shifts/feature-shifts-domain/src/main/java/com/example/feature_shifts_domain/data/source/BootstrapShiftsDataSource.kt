package com.example.feature_shifts_domain.data.source

import android.content.Context
import com.example.feature_shifts_domain.data.model.ShiftModel
import com.example.feature_shifts_domain.entity.Shift
import com.example.homebase.data.extension.getParsedJsonDataFromAsset
import com.example.homebase.domain.errorhandling.Error
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.squareup.moshi.Moshi
import java.io.IOException

const val SHIFTS_JSON_FILE = "shifts.json"

class BootstrapShiftsDataSource(
    private val context: Context,
    private val moshi: Moshi
) {

    fun fetchLocalShiftss(): Result<List<Shift>, Error> {
        return if (gsonParsing != null) {
            Ok(gsonParsing!!.shifts)
        } else {
            Err(IOException("Parsing Error"))
        }
    }

    private val gsonParsing: ShiftModel?
        get() = moshi.getParsedJsonDataFromAsset(context, SHIFTS_JSON_FILE, ShiftModel::class.java)

}