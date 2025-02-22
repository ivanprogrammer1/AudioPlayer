package com.tattoshaman.audioplayer.composable.di

import com.tattoshaman.audioplayer.composable.MainVMFactory
import com.tattoshaman.player.PlayerLifecycle

object MainDI {
    lateinit var controllerLifecycle: PlayerLifecycle
    lateinit var factory: MainVMFactory
}