package com.tattoshaman.features.audiolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.tattoshaman.features.audiolist.entities.AudioItem
import com.tattoshaman.features.audiolist.entities.toUI
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal data class State(
    val list: ImmutableList<AudioItem> = persistentListOf()
)

internal class AudioListViewModel(
    private val getAudiosUseCase: GetAudiosUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    init {
        updateList()
    }

    fun updateList() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    list = getAudiosUseCase.execute().map { it.toUI() }.toPersistentList()
                )
            }
        }
    }
}

class AudioListVMFactory(private val getAudiosUseCase: GetAudiosUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AudioListViewModel(getAudiosUseCase) as T
    }
}