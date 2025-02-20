package com.tattoshaman.core.time

import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun LocalTime.formatString(): String {
    return this.format(DateTimeFormatter.ofPattern("H:m:s"))
}