package com.tattoshaman.audioplayer.composable

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tattoshaman.audioplayer.composable.ui.MusicContainerWidget
import com.tattoshaman.features.audiolist.AudioListDestination
import com.tattoshaman.features.audiolist.list

@Composable
fun MainPage(
    state: MainState,
    togglePlaying: () -> Unit,
    backPlaying: () -> Unit,
    nextPlaying: () -> Unit,
    selectAudio: (Uri) -> Unit
) {
    Scaffold { paddings ->
        Box(modifier = Modifier.padding(paddings)) {
            MusicContainerWidget(
                state = state.musicState,
                togglePlaying = togglePlaying,
                backPlaying = backPlaying,
                nextPlaying = nextPlaying
            ) { domainPaddings ->
                NavHost(
                    modifier = Modifier.padding(domainPaddings),
                    navController = rememberNavController(),
                    startDestination = AudioListDestination
                ) {
                    list(selectMusic = selectAudio)
                }
            }
        }
    }
}