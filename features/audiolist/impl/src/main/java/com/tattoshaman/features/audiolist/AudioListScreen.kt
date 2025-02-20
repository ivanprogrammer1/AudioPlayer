package com.tattoshaman.features.audiolist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tattoshaman.features.audiolist.ui.ListItem

@Composable
internal fun AudioListScreen(
    state: State
) {
    LazyColumn {
        items(state.list) {
            ListItem(it)
        }
    }
}

@Preview
@Composable
private fun PreviewAudioListScreen(){
    AudioListScreen(State())
}