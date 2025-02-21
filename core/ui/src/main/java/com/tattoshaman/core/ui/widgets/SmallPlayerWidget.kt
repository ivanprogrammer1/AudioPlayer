package com.tattoshaman.core.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.media3.common.Player

@Composable
fun SmallPlayerWidget(player: Player?, modifier: Modifier = Modifier) {
    var playerIsPlaying by remember {
        mutableStateOf(player?.isPlaying ?: false)
    }

    LaunchedEffect(player) {
        player?.addListener(object : Player.Listener {
            override fun onIsPlayingChanged(isPlaying: Boolean) {
                super.onIsPlayingChanged(isPlaying)
            }
        })
    }

    Box(
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = {}
            ) {
            }

            IconButton(
                onClick = {}
            ) {
                if(playerIsPlaying){
                    
                }
                else{

                }
            }

            IconButton(
                onClick = {}
            ) {
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewSmallPlayerWidget() {
    SmallPlayerWidget(null)
}