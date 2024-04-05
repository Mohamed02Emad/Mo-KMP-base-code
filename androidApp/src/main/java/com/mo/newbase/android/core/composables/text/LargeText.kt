package com.mo.newbase.android.core.composables.text

import android.annotation.SuppressLint
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun LargeText(
    text: String,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
     color: Color = MaterialTheme.colorScheme.onPrimary,
) {
    BasicText(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyLarge.copy(color = color)
    )
}