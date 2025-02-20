package com.tattoshaman.features.audiolist.mock

import android.net.Uri
import com.tattoshaman.features.audiolist.entities.AudioItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import java.time.LocalTime

internal fun getItems(): ImmutableList<AudioItem> {
    return persistentListOf(
        AudioItem(
            id = 1,
            name = "Robus",
            time = LocalTime.of(0, 3, 10),
            uri = Uri.EMPTY
        )
    )
}