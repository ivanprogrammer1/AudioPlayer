package com.tattoshaman.player

import androidx.media3.session.MediaController
import java.util.concurrent.Future

interface PlayerController{
    fun onCreate()
    fun getController(): Future<MediaController>
    fun onDestroy()
}