package com.tattoshaman.features.audiolist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.media3.common.Player.Listener
import com.tattoshaman.features.audiolist.entities.AudioItem
import com.tattoshaman.features.audiolist.entities.toUI
import com.tattoshaman.player.PlayerController
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal sealed interface HasPermissionState {
    data object Success : HasPermissionState
    data object NeedRequest : HasPermissionState
    data object Cancel : HasPermissionState
}

internal sealed interface Effect {
    data object RequestPermission : Effect
}

internal data class State(
    val list: ImmutableList<AudioItem> = persistentListOf(),
    val selectedItem: AudioItem? = null,
    val hasPermissionState: HasPermissionState = HasPermissionState.NeedRequest
)

internal class AudioListViewModel(
    private val getAudiosUseCase: GetAudiosUseCase,
    private val playerController: PlayerController
) : ViewModel() {
    private val _effect = MutableStateFlow<Effect?>(null)
    val effect = _effect.asStateFlow()

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    fun subscribeOnController() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val controller = playerController.getController()
                controller.addListener(object : Listener {
                    override fun onPlaybackStateChanged(playbackState: Int) {
                        super.onPlaybackStateChanged(playbackState)
                        val currentUri = controller.currentMediaItem?.localConfiguration?.uri
                        _state.update {
                            it.copy(
                                selectedItem = it.list.firstOrNull { item -> item.uri == currentUri }
                            )
                        }
                    }
                })
            }
        }
    }

    fun clearEffect() {
        _effect.update {
            null
        }
    }

    fun requestIsSuccess(success: Boolean) {
        if (success) {
            _state.update {
                it.copy(
                    hasPermissionState = HasPermissionState.Success
                )
            }
            _updateList()
        } else {
            _state.update {
                it.copy(
                    hasPermissionState = HasPermissionState.Cancel
                )
            }
        }
    }

    fun updateList() {
        _state.update {
            it.copy(
                hasPermissionState = HasPermissionState.NeedRequest
            )
        }
        _effect.update {
            Effect.RequestPermission
        }
    }

    private fun _updateList() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    list = getAudiosUseCase.execute().map {
                        it.toUI()
                    }.toPersistentList()
                )
            }
        }
    }
}

class AudioListVMFactory(
    private val getAudiosUseCase: GetAudiosUseCase,
    private val playerController: PlayerController
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AudioListViewModel(getAudiosUseCase, playerController) as T
    }
}