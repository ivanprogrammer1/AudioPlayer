package com.tattoshaman.core.ui.utils

import androidx.annotation.DrawableRes
import com.tattoshaman.core.ui.R

@DrawableRes
fun getGradientResource(index: Int): Int{
    val position = index % 10
    return when(position){
        0 -> R.drawable.gradient1
        1 -> R.drawable.gradient2
        2 -> R.drawable.gradient3
        3 -> R.drawable.gradient4
        4 -> R.drawable.gradient5
        5 -> R.drawable.gradient6
        6 -> R.drawable.gradient7
        7 -> R.drawable.gradient8
        8 -> R.drawable.gradient9
        9 -> R.drawable.gradient10
        else -> R.drawable.common_placeholder
    }
}