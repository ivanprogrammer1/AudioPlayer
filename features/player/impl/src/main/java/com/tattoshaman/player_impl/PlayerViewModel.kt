package com.tattoshaman.player_impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.media3.session.MediaController
import com.tattoshaman.core.coroutines.CoroutineDispatchers
import com.tattoshaman.player.PlayerController
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.withContext

internal class PlayerViewModel(
    private val playerController: PlayerController,
    private val dispatchers: CoroutineDispatchers
) : ViewModel() {
    val player = flow<MediaController?> {
        emit(withContext(dispatchers.IO) {
            playerController.getController().get()
        })
    }.shareIn(viewModelScope, SharingStarted.WhileSubscribed())

    init {
        playerController.onCreate()
    }

    override fun onCleared() {
        super.onCleared()
        playerController.onDestroy()
    }
}

class PlayerViewModelFactory(
    private val playerController: PlayerController,
    private val dispatchers: CoroutineDispatchers
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PlayerViewModel(playerController, dispatchers) as T
    }
}