package com.tattoshaman.domain.repositories

import com.tattoshaman.domain.entities.Audio

interface AudioRepository {
    suspend fun getList(): List<Audio>
}