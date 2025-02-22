package com.tattoshaman.audioplayer.composable

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.session.MediaController
import com.tattoshaman.audioplayer.composable.ui.MusicState
import com.tattoshaman.core.coroutines.CoroutineDispatchers
import com.tattoshaman.player.PlayerController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class MainState(
    val musicState: MusicState = MusicState()
)

class MainViewModel(
    private val playerController: PlayerController,
) : ViewModel() {
    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    private val _player = MutableStateFlow<MediaController?>(null)

    fun subscribeController() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val controller = playerController.getController()
                _player.emit(controller)
                _state.update {
                    it.copy(
                        musicState = it.musicState.copy(
                            player = controller
                        )
                    )
                }

                controller.addListener(object : Player.Listener {
                    override fun onIsPlayingChanged(isPlaying: Boolean) {
                        super.onIsPlayingChanged(isPlaying)
                        updateIsPlaying(isPlaying)
                    }
                })
            }
        }
    }

    private fun updateIsPlaying(isPlaying: Boolean) {
        _state.update {
            it.copy(
                musicState = it.musicState.copy(
                    isPlaying = isPlaying
                )
            )
        }
    }

    fun playItem(uri: Uri) {
        _player.value?.apply {
            setMediaItem(MediaItem.fromUri(uri))
            prepare()
            play()
        }
    }

    fun playBack() {
        _player.value?.seekToPrevious()
    }

    fun playNext() {
        _player.value?.seekToNext()
    }

    fun togglePlay() {
        _player.value?.let {
            if (it.isPlaying) {
                _player.value?.pause()
            } else {
                _player.value?.play()
            }
        }
    }
}

class MainVMFactory(
    private val playerController: PlayerController,
    private val dispatchers: CoroutineDispatchers
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(playerController) as T
    }
}