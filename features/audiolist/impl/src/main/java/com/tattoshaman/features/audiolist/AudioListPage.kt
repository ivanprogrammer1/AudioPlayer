package com.tattoshaman.features.audiolist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tattoshaman.features.audiolist.di.AudioListDI

@Composable
fun AudioListPage() {
    val viewModel = viewModel<AudioListViewModel>(factory = AudioListDI.factory)
    val state by viewModel.state.collectAsState()
    AudioListScreen(state) {

    }
}