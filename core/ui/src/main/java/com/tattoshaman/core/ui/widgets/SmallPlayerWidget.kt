package com.tattoshaman.core.ui.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tattoshaman.core.ui.R

@Composable
fun SmallPlayerWidget(
    isPlaying: Boolean,
    togglePlaying: () -> Unit,
    backClick: () -> Unit,
    nextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Row {
            IconButton(
                onClick = backClick
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_left_arrow),
                    contentDescription = stringResource(R.string.back),
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            IconButton(
                onClick = togglePlaying
            ) {
                Icon(
                    painter = painterResource(isPlaying.toggleResource()),
                    contentDescription = stringResource(R.string.toggle),
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            IconButton(
                onClick = nextClick
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_right_arrow),
                    contentDescription = stringResource(R.string.next),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewSmallPlayerWidget() {
    SmallPlayerWidget(true, togglePlaying = {}, backClick = {}, nextClick = {})
}