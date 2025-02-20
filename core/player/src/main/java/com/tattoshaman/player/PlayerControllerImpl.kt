package com.tattoshaman.player

import android.app.Application
import android.content.ComponentName
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import java.util.concurrent.Future

class PlayerControllerImpl(
    private val application: Application
) : PlayerController {
    private lateinit var sessionToken: SessionToken
    private lateinit var controllerFuture: Future<MediaController>

    override fun onCreate() {
        sessionToken =
            SessionToken(application, ComponentName(application, AudioService::class.java))
        controllerFuture = MediaController.Builder(application, sessionToken).buildAsync()
    }

    override fun getController(): Future<MediaController> {
        return controllerFuture
    }

    override fun onDestroy() {
        MediaController.releaseFuture(controllerFuture)
    }
}