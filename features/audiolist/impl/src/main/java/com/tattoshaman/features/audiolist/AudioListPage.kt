package com.tattoshaman.features.audiolist

import android.Manifest
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
fun AudioListPage() {
    val viewModel = viewModel<AudioListViewModel>(factory = AudioListDI.factory)

    val readStoragePermissionRequest =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { hasPermission ->
            viewModel.requestIsSuccess(hasPermission)
        }

    LaunchedEffect(Unit) {
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
    AudioListScreen(state) {

    }
}