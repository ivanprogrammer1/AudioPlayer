package com.tattoshaman.audioplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tattoshaman.audioplayer.di.MainDI
import com.tattoshaman.audioplayer.navigation.MainNavHost
import com.tattoshaman.core.ui.theme.AudioPlayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AudioPlayerTheme {
                MainNavHost()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
