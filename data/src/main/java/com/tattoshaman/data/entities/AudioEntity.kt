package com.tattoshaman.data.entities

import android.net.Uri
import com.tattoshaman.domain.entities.Audio
import java.net.URI

data class AudioEntity(
    val id: Int,
    val uri: Uri,
    val name: String
)

internal fun AudioEntity.toDomain(): Audio{
    return Audio(
        id = id,
        name = name,
        path = URI.create(uri.normalizeScheme().path)
    )
}