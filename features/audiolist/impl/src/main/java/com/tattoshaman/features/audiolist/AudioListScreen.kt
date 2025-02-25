package com.tattoshaman.features.audiolist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tattoshaman.core.ui.theme.AudioPlayerTheme
import com.tattoshaman.core.ui.utils.getGradientResource
import com.tattoshaman.features.audiolist.entities.AudioItem
import com.tattoshaman.features.audiolist.mock.getItems
import com.tattoshaman.features.audiolist.ui.ListItem

@Composable
internal fun AudioListScreen(
    state: State,
    onSelectAudio: (AudioItem) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(
            start = 13.dp,
            end = 20.dp
        ),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(state.list) {index, item ->
            ListItem(
                item = item,
                imagePainter = painterResource(getGradientResource(index)),
                isSelected = state.selectedItem == item,
                modifier = Modifier.fillMaxWidth(),
                onClick = { onSelectAudio(item) }
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewAudioListScreen() {
    AudioPlayerTheme {
        AudioListScreen(
            State(
                list = getItems()
            )
        ) {

        }
    }
}