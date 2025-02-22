package com.tattoshaman.player

import androidx.media3.session.MediaController

interface PlayerController {
    suspend fun getController(): MediaController
}

interface PlayerLifecycle {
    fun onCreate()
    fun onDestroy()
}