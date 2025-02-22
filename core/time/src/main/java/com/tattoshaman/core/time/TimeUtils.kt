package com.tattoshaman.core.time

import java.time.LocalTime

fun LocalTime.formatString(): String {
    return this.toString()
}

fun Long.toLocalTime(): LocalTime{
    val totalSeconds: Long = this / 1000

    val hours = (totalSeconds / 3600).toInt()
    val minutes = ((totalSeconds % 3600) / 60).toInt()
    val seconds = (totalSeconds % 60).toInt()

    return LocalTime.of(hours, minutes, seconds)
}