package com.mo.newbase.android.core.composables
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import kotlinx.coroutines.launch

@Composable
fun RotationClicker(
    content: @Composable () -> Unit,
) {
    val rotation = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier
        .clip(CircleShape)
        .clickable {
            scope.launch {
                rotation.animateTo(
                    targetValue = 180f,
                    animationSpec = tween(500, easing = LinearEasing)
                )
                rotation.animateTo(
                    targetValue = 360f,
                    animationSpec = tween(500, easing = LinearEasing)
                )
                rotation.snapTo(0f)
            }
        }
        .rotate(rotation.value)
    ) {
        content()
    }
}