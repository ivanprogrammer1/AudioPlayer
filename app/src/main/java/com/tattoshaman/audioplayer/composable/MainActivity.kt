package com.tattoshaman.audioplayer.composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tattoshaman.audioplayer.composable.di.MainDI
import com.tattoshaman.core.ui.theme.AudioPlayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainDI.controllerLifecycle.onCreate()

        enableEdgeToEdge()
        setContent {
            AudioPlayerTheme {
                ApplicationMainPoint()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        MainDI.controllerLifecycle.onDestroy()
    }
}
