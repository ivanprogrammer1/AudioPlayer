package com.tattoshaman.features.audiolist

import android.Manifest
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tattoshaman.features.audiolist.di.AudioListDI
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
internal fun AudioListPage(
    selectMusic: (Uri) -> Unit
) {
    val viewModel = viewModel<AudioListViewModel>(factory = AudioListDI.factory)

    val readStoragePermissionRequest =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { hasPermission ->
            viewModel.requestIsSuccess(hasPermission)
        }

    LaunchedEffect(Unit) {
        viewModel.subscribeOnController()
        launch {
            viewModel.effect.collectLatest {
                when (it) {
                    Effect.RequestPermission -> {
                        readStoragePermissionRequest.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                    }

                    else -> {}
                }
                if (it != null) {
                    viewModel.clearEffect()
                }
            }
        }
        viewModel.updateList()
    }

    val state by viewModel.state.collectAsState()
    AudioListScreen(state, onSelectAudio = {
        selectMusic(it.uri)
    })
}