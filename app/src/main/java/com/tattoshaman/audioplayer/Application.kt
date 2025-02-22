package com.tattoshaman.audioplayer

import android.app.Application
import com.tattoshaman.audioplayer.composable.di.MainDI
import com.tattoshaman.audioplayer.composable.MainVMFactory
import com.tattoshaman.core.coroutines.CoroutineDispatchers
import com.tattoshaman.data.AudioRepositoryImpl
import com.tattoshaman.data.AudioStorageImpl
import com.tattoshaman.features.audiolist.AudioListVMFactory
import com.tattoshaman.features.audiolist.GetAudiosUseCase
import com.tattoshaman.features.audiolist.di.AudioListDI
import com.tattoshaman.player.PlayerControllerImpl
import kotlinx.coroutines.Dispatchers

class AudioApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI(){
        val controller = PlayerControllerImpl(this)

        MainDI.controllerLifecycle = controller
        MainDI.factory = MainVMFactory(
            controller,
            CoroutineDispatchers(
                Main = Dispatchers.Main,
                IO = Dispatchers.IO
            )
        )
        AudioListDI.factory = AudioListVMFactory(
            GetAudiosUseCase(
                AudioRepositoryImpl(
                    AudioStorageImpl(
                        contentResolver
                    )
                )
            ),
            playerController = controller
        )
    }
}