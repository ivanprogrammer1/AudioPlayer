package com.tattoshaman.audioplayer.composable.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.tattoshaman.core.ui.widgets.PlayerWidget
import com.tattoshaman.core.ui.widgets.SmallPlayerWidget

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicContainerWidget(
    state: MusicState,
    togglePlaying: () -> Unit,
    backPlaying: () -> Unit,
    nextPlaying: () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    BottomSheetScaffold(
        sheetShape = RectangleShape,
        sheetDragHandle = {
            SmallPlayerWidget(
                state.isPlaying,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(67.dp)
                    .padding(vertical = 11.dp),
                togglePlaying = togglePlaying,
                backClick = backPlaying,
                nextClick = nextPlaying
            )
        },
        sheetPeekHeight = 67.dp,
        sheetContent = {
            PlayerWidget(
                player = state.player,
                modifier = Modifier.fillMaxSize()
            )
        },
        content = content
    )
}