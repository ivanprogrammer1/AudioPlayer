package com.tattoshaman.features.audiolist.mock

import com.tattoshaman.features.audiolist.entities.AudioItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import java.time.LocalTime

internal fun getItems(): ImmutableList<AudioItem>{
    return persistentListOf(
        AudioItem(
            id = 1,
            name = "Robus",
            time = LocalTime.of(0, 3, 10)
        ),
        AudioItem(
            id = 1,
            name = "My ladwe",
            time = LocalTime.of(0, 3, 10)
        ),
        AudioItem(
            id = 1,
            name = "Abobus",
            time = LocalTime.of(0, 3, 10)
        ),
        AudioItem(
            id = 1,
            name = "Trkobus",
            time = LocalTime.of(0, 3, 10)
        ),
        AudioItem(
            id = 1,
            name = "Ahahahahah",
            time = LocalTime.of(0, 3, 10)
        ),
        AudioItem(
            id = 1,
            name = "BabaObaba",
            time = LocalTime.of(0, 3, 10)
        )
    )
}