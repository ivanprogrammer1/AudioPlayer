package com.tattoshaman.data.entities

import android.net.Uri
import com.tattoshaman.core.time.toLocalTime
import com.tattoshaman.domain.entities.Audio

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
        path = uri.toString(),
        duration = duration.toLocalTime()
    )
}