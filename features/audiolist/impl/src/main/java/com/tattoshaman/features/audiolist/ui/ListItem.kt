package com.tattoshaman.features.audiolist.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil3.compose.AsyncImage
import com.tattoshaman.core.time.formatString
import com.tattoshaman.features.audiolist.entities.AudioItem
import com.tattoshaman.features.audiolist.mock.getItems

@Composable
internal fun ListItem(
    item: AudioItem,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ConstraintLayout(
        modifier = modifier.clip(RoundedCornerShape(10.dp)).clickable(onClick = onClick)
    ) {
        val (image, informationBox, play) = createRefs()

        AsyncImage(
            modifier = Modifier.size(63.dp).constrainAs(image) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            },
            model = "",
            placeholder = painterResource(com.tattoshaman.core.ui.R.drawable.common_placeholder),
            error = painterResource(com.tattoshaman.core.ui.R.drawable.common_placeholder),
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
                text = item.name
            )
            
            Spacer(modifier = Modifier.height(2.dp))
            
            Text(
                text = item.time.formatString()
            )
        }

        IconButton(
            onClick = {},
            modifier = Modifier.constrainAs(play) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        ) {
            Icon(
                painter = painterResource(com.tattoshaman.core.ui.R.drawable.ic_play),
                contentDescription = null
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewListItem() {
    ListItem(
        getItems()[0], modifier = Modifier.fillMaxWidth(), onClick = {}
    )
}