package com.tattoshaman.player

import android.util.Log
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService

class AudioService: MediaSessionService() {
    private var mediaSession: MediaSession? = null

    override fun onCreate() {
        super.onCreate()
        Log.d("MyTag", "CreateService")
        val player = ExoPlayer.Builder(application).build()
        mediaSession = MediaSession.Builder(application, player).build()
    }

    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaSession? {
        Log.d("MyTag", "Get session")
        return mediaSession
    }

    override fun onDestroy() {
        Log.d("MyTag", "OnDestroy service")
        mediaSession?.run {
            player.release()
            release()
            mediaSession = null
        }
        super.onDestroy()
    }
}