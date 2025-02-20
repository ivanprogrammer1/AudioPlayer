package com.tattoshaman.core.time

import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun LocalTime.formatString(): String {
    return this.format(DateTimeFormatter.ofPattern("H:m:s"))
}

fun Long.toLocalTime(): LocalTime{
    val totalSeconds: Long = this / 1000

    val hours = (totalSeconds / 3600).toInt()
    val minutes = ((totalSeconds % 3600) / 60).toInt()
    val seconds = (totalSeconds % 60).toInt()

    return LocalTime.of(hours, minutes, seconds)
}