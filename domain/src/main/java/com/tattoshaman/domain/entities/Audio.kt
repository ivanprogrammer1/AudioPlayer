package com.tattoshaman.domain.entities

import java.net.URI
import java.time.LocalTime

data class Audio(
    val id: Long,
    val duration: LocalTime,
    val name: String,
    val path: URI
)