package com.tattoshaman.features.audiolist

import androidx.lifecycle.ViewModel
import com.tattoshaman.features.audiolist.entities.AudioItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

internal data class State(
    val list: ImmutableList<AudioItem> = persistentListOf()
)

internal class AudioListViewModel: ViewModel() {
}