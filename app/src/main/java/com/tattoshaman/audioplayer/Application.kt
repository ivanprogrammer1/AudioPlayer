package com.tattoshaman.audioplayer

import android.app.Application
import android.provider.MediaStore
import com.tattoshaman.core.coroutines.CoroutineDispatchers
import com.tattoshaman.data.AudioRepositoryImpl
import com.tattoshaman.data.AudioStorageImpl
import com.tattoshaman.features.audiolist.AudioListVMFactory
import com.tattoshaman.features.audiolist.GetAudiosUseCase
import com.tattoshaman.features.audiolist.di.AudioListDI
import com.tattoshaman.player.PlayerController
import com.tattoshaman.player.PlayerControllerImpl
import com.tattoshaman.player_impl.PlayerViewModelFactory
import com.tattoshaman.player_impl.di.PlayerDI
import kotlinx.coroutines.Dispatchers

object DI{
    lateinit var controller: PlayerController
}

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

        DI.controller = PlayerControllerImpl(this)
        DI.controller.onCreate()
        PlayerDI.factory = PlayerViewModelFactory(
            DI.controller,
            dispatchers
        )

        AudioListDI.factory = AudioListVMFactory(
            GetAudiosUseCase(
                AudioRepositoryImpl(
                    AudioStorageImpl(
                        contentResolver
                    )
                )
            )
        )
    }

}