package com.tattoshaman.features.audiolist.entities

import android.net.Uri
import com.tattoshaman.domain.entities.Audio
import java.time.LocalTime

data class AudioItem(
    val id: Long,
    val name: String,
    val uri: Uri,
    val time: LocalTime,
)

internal fun Audio.toUI(): AudioItem {
    return AudioItem(
        id = id,
        name = name,
        uri = Uri.parse(path),
        time = LocalTime.of(0, 0)
    )
}