package com.example.homebase.data.extension

import android.content.Context
import com.squareup.moshi.Moshi
import java.io.IOException

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

fun <T> Moshi.getParsedJsonDataFromAsset(context: Context, fileName: String, cls: Class<T>): T? {
    val jsonString = getJsonDataFromAsset(context, fileName)

    return adapter(cls).fromJson(jsonString ?: "")
}