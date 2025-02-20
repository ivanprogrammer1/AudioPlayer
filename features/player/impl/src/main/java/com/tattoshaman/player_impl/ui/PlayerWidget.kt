package com.tattoshaman.player_impl.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.Player
import androidx.media3.ui.PlayerView

@Composable
internal fun PlayerWidget(
    player: Player?
){
    val context = LocalContext.current
    val view by remember{
        mutableStateOf(PlayerView(context))
    }

    AndroidView(
        factory = {
            view
        },
        modifier = Modifier,
        onReset = null,
        onRelease = {
            view.player = null
        },
        update = {
            view.player = player
        }
    )
}