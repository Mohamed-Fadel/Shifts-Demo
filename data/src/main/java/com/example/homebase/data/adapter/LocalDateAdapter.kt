package com.example.homebase.data.adapter

import com.example.homebase.shared.utils.ext.YYYYMMDDHHmmssZ_FORMAT
import com.squareup.moshi.*
import org.threeten.bp.LocalDateTime

class LocalDateAdapter : JsonAdapter<LocalDateTime>() {

    @FromJson
    override fun fromJson(reader: JsonReader): LocalDateTime? {
        return LocalDateTime.parse(reader.nextString(), YYYYMMDDHHmmssZ_FORMAT)
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: LocalDateTime?) {
        writer.jsonValue(value?.toString())
    }

}