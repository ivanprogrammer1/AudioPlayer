package com.tattoshaman.player_impl

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.media3.common.Player
import com.tattoshaman.player_impl.ui.PlayerWidget

@Composable
internal fun PlayerScreen(
    player: Player?
) {
    PlayerWidget(player)
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewPlayerScreen(){
    PlayerScreen(null)
}