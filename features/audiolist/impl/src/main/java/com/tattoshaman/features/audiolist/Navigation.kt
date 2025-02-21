package com.tattoshaman.features.audiolist

import android.net.Uri
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.list(selectMusic: (Uri) -> Unit) {
    composable<AudioListDestination> {
        AudioListPage(selectMusic = selectMusic)
    }
}