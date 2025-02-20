package com.tattoshaman.data.entities

import android.net.Uri
import android.util.Log
import com.tattoshaman.core.time.toLocalTime
import com.tattoshaman.domain.entities.Audio
import java.net.URI
import java.time.LocalTime

data class AudioEntity(
    val id: Long,
    val uri: Uri,
    val duration: Long,
    val name: String
)

internal fun AudioEntity.toDomain(): Audio{
    return Audio(
        id = id,
        name = name,
        path = URI.create(uri.normalizeScheme().path),
        duration = duration.toLocalTime()
    )
}