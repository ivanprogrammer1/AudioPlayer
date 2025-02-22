package com.tattoshaman.core.ui.widgets

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
fun PlayerWidget(
    player: Player?,
    modifier: Modifier = Modifier
){
    val context = LocalContext.current
    val view by remember{
        mutableStateOf(PlayerView(context))
    }

    AndroidView(
        factory = {
            view
        },
        modifier = modifier,
        onReset = null,
        onRelease = {
            view.player = null
        },
        update = {
            view.player = player
        }
    )
}