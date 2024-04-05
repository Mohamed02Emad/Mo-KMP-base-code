package com.mo.newbase.android.core.composables.text

import android.annotation.SuppressLint
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SmallText(
    text: String,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    maxLines : Int = 3,
    color: Color = MaterialTheme.colorScheme.onPrimary,
) {
    BasicText(
        modifier = modifier,
        text = text,
        maxLines = maxLines,
        style = MaterialTheme.typography.bodySmall.copy(color = color)
    )
}