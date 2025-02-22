package com.tattoshaman.core.ui.widgets

import androidx.annotation.DrawableRes
import com.tattoshaman.core.ui.R

@DrawableRes
internal fun Boolean.toggleResource(): Int{
    return if(this) R.drawable.ic_pause else R.drawable.ic_play
}