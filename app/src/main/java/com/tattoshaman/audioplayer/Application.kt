package com.tattoshaman.audioplayer

import android.app.Application
import com.tattoshaman.core.coroutines.CoroutineDispatchers
import com.tattoshaman.player.PlayerControllerImpl
import com.tattoshaman.player_impl.PlayerViewModelFactory
import com.tattoshaman.player_impl.di.PlayerDI
import kotlinx.coroutines.Dispatchers

class AudioApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI(){
        val dispatchers = CoroutineDispatchers(
            Dispatchers.Main,
            Dispatchers.IO
        )

        PlayerDI.factory = PlayerViewModelFactory(
            PlayerControllerImpl(this),
            dispatchers
        )
    }
}