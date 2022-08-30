package com.example.homebase.shared.utils.ext

import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

val LocalDateTime.MMM_FORMAT
    get() = this.format(DateTimeFormatter.ofPattern("MMM"))

val LocalDateTime.EEE_FORMAT
    get() = this.format(DateTimeFormatter.ofPattern("EEE"))

val LocalDateTime.d_FORMAT
    get() = this.format(DateTimeFormatter.ofPattern("d"))

val LocalDateTime.HHmma_FORMAT
    get() = this.format(DateTimeFormatter.ofPattern("HH:mm a"))


val YYYYMMDDHHmm_FORMAT
    get() = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

val YYYYMMDDHHmmssZ_FORMAT
    get() = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z")


val YYYY_MM_DD_FORAMT = "yyyy-MM-dd"