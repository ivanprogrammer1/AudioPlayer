package com.tattoshaman.features.audiolist.entities

import java.time.LocalTime

data class AudioItem(
    val id: Int,
    val name: String,
    val time: LocalTime,
)