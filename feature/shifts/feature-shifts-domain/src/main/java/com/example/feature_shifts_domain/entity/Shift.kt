package com.example.feature_shifts_domain.entity

import androidx.annotation.StringRes
import com.example.homebase.feature_shifts_domain.R
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.threeten.bp.LocalDateTime

enum class Role(@StringRes val resId: Int) {
    @Json(name = "Waiter")
    WAITER(R.string.role_waiter),

    @Json(name = "Prep")
    PREP(R.string.role_prep),

    @Json(name = "Front of House")
    FRONT_OF_HOUSE(R.string.front_of_house_role),

    @Json(name = "Cook")
    COOK(R.string.role_cook)
}

enum class Color(@StringRes val resId: Int, val hexValue: String) {
    @Json(name = "red")
    RED(R.string.red, "#FFFF0000"),

    @Json(name = "blue")
    BLUE(R.string.blue, "#FF0000FF"),

    @Json(name = "green")
    GREEN(R.string.green, "#FF00FF00")
}

@JsonClass(generateAdapter = true)
data class Shift(
    val role: Role,
    val name: String,
    @Json(name = "start_date")
    val startDate: LocalDateTime,
    @Json(name = "end_date")
    val endDate: LocalDateTime,
    val color: Color
)
