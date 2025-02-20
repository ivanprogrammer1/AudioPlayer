package com.tattoshaman.features.audiolist

import com.tattoshaman.domain.entities.Audio
import com.tattoshaman.domain.repositories.AudioRepository

class GetAudiosUseCase(private val audioRepository: AudioRepository) {
    suspend fun execute(): List<Audio> {
        return audioRepository.getList()
    }
}