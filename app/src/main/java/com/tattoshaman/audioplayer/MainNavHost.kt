package com.tattoshaman.audioplayer

import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SheetVisual() {
    BottomSheetScaffold(
        sheetDragHandle = {
            Button(onClick = {}) {
                Text("Мой минимальный музыкальный плеер")
            }
        },
        sheetContent = {

        }
    ) {

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewSheet() {
    SheetVisual()
}