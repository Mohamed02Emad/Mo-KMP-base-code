package com.mo.newbase.android.core.composables.text

import android.annotation.SuppressLint
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
fun MediumText(
    text: String,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    fontSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize,
) {
    BasicText(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium.copy(fontSize = fontSize, color = color, textAlign = TextAlign.Center)
    )
}