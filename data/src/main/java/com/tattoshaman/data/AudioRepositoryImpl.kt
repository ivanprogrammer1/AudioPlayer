package com.tattoshaman.data

import com.tattoshaman.data.entities.toDomain
import com.tattoshaman.domain.entities.Audio
import com.tattoshaman.domain.repositories.AudioRepository

class AudioRepositoryImpl(private val audioStorage: AudioStorage): AudioRepository {
    override suspend fun getList(): List<Audio> {
        return audioStorage.getList().map {
            it.toDomain()
        }
    }
}