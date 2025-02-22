package com.tattoshaman.audioplayer.composable.ui

import androidx.media3.common.Player

data class MusicState(
    val isPlaying: Boolean = false,
    val player: Player? = null
)