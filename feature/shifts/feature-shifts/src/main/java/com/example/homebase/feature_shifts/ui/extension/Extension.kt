package com.example.homebase.feature_shifts.ui.extension

import com.jaredrummler.materialspinner.MaterialSpinner

fun <T> MaterialSpinner.getSelectedItem() = getItems<T>()[selectedIndex]