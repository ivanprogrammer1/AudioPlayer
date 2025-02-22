package com.tattoshaman.audioplayer.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.MediaItem
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tattoshaman.audioplayer.composable.di.MainDI
import com.tattoshaman.audioplayer.composable.ui.MusicContainerWidget
import com.tattoshaman.audioplayer.composable.ui.MusicState
import com.tattoshaman.features.audiolist.AudioListDestination
import com.tattoshaman.features.audiolist.list

@Composable
fun ApplicationMainPoint(
    viewModel: MainViewModel = viewModel<MainViewModel>(factory = MainDI.factory)
) {
    LaunchedEffect(Unit) {
        viewModel.subscribeController()
    }

    val state by viewModel.state.collectAsState()

    MainPage(
        state = state,
        togglePlaying = viewModel::togglePlay,
        backPlaying = viewModel::playBack,
        nextPlaying = viewModel::playNext,
        selectAudio = viewModel::playItem
    )
}