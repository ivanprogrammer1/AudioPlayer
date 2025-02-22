package com.tattoshaman.features.audiolist.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
internal fun Boolean.colorChecked(): Color{
    return if(this) MaterialTheme.colorScheme.onPrimary else Color.Unspecified
}