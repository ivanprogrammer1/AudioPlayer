package com.tattoshaman.data

import com.tattoshaman.data.entities.AudioEntity

interface AudioStorage {
    suspend fun getList(): List<AudioEntity>
}