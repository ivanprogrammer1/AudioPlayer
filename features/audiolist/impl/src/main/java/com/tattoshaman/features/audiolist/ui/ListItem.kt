package com.tattoshaman.features.audiolist.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil3.compose.AsyncImage
import com.tattoshaman.core.time.formatString
import com.tattoshaman.core.ui.theme.AudioPlayerTheme
import com.tattoshaman.features.audiolist.R
import com.tattoshaman.features.audiolist.entities.AudioItem
import com.tattoshaman.features.audiolist.mock.getItems

@Composable
internal fun ListItem(
    item: AudioItem,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    imagePainter: Painter? = null,
    onClick: () -> Unit
) {
    ConstraintLayout(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
            .background(isSelected.colorChecked())
    ) {
        val (image, informationBox, play) = createRefs()

        AsyncImage(
            modifier = Modifier
                .clip(RoundedCornerShape(60.dp))
                .size(63.dp)
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            contentScale = ContentScale.Crop,
            model = "",
            placeholder = imagePainter,
            error = imagePainter,
            contentDescription = ""
        )

        Column(
            modifier = Modifier.constrainAs(informationBox) {
                start.linkTo(image.end, 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
            
            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = item.time.formatString(),
                style = MaterialTheme.typography.labelMedium.copy(
                    color = MaterialTheme.colorScheme.onSecondary
                )
            )
        }

        IconButton(
            onClick = {},
            enabled = false,
            modifier = Modifier.constrainAs(play) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        ) {
            Icon(
                painter = painterResource(com.tattoshaman.core.ui.R.drawable.ic_play),
                contentDescription = stringResource(R.string.play),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewListItem() {
    AudioPlayerTheme {
        ListItem(
            getItems()[0], modifier = Modifier.fillMaxWidth(), isSelected = true, onClick = {}
        )
    }
}