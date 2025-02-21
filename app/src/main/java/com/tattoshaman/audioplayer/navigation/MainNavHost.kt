package com.tattoshaman.audioplayer.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.MediaItem
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tattoshaman.audioplayer.MainViewModel
import com.tattoshaman.audioplayer.di.MainDI
import com.tattoshaman.core.ui.widgets.PlayerWidget
import com.tattoshaman.features.audiolist.AudioListDestination
import com.tattoshaman.features.audiolist.list

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavHost() {
    val viewModel = viewModel<MainViewModel>(factory = MainDI.factory)
    val player by viewModel.player.collectAsState(null)

    Scaffold { paddings ->
        Box(modifier = Modifier.padding(paddings)) {
            BottomSheetScaffold(
                sheetShape = RectangleShape,
                sheetDragHandle = {
                    Text(
                        text = "drag me",
                        modifier = Modifier.height(75.dp)
                    )
                },
                sheetPeekHeight = 75.dp,
                sheetContent = {
                    PlayerWidget(
                        player = player,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            ) { domainPaddings ->
                NavHost(
                    modifier = Modifier.padding(domainPaddings),
                    navController = rememberNavController(),
                    startDestination = AudioListDestination
                ) {
                    list {
                        player?.apply {
                            setMediaItem(MediaItem.fromUri(it))
                            prepare()
                            play()
                        }
                    }
                }
            }
        }
    }
}