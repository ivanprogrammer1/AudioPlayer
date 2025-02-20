package com.tattoshaman.features.audiolist.entities

import com.tattoshaman.domain.entities.Audio
import java.time.LocalTime

data class AudioItem(
    val id: Int,
    val name: String,
    val time: LocalTime,
)

internal fun Audio.toUI(): AudioItem {
    return AudioItem(
        id = id,
        name = name,
        time = LocalTime.of(0, 0)
    )
}