package com.tattoshaman.player_impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tattoshaman.player_impl.di.PlayerDI

@Composable
fun PlayerPage() {
    val viewModel = viewModel<PlayerViewModel>(factory = PlayerDI.factory)
    val player by viewModel.player.collectAsState(null)
    PlayerScreen(player)
}