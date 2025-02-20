package com.tattoshaman.domain.entities

import java.net.URI

data class Audio(
    val id: Int,
    val name: String,
    val path: URI
)