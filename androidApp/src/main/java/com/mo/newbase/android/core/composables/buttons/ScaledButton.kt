package com.mo.newbase.android.core.composables.buttons
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mo.newbase.android.core.AppMainRadius
import kotlinx.coroutines.launch

@Composable
fun ScaledButton(
    modifier: Modifier = Modifier,
    animationDuration: Int = 100,
    scaleDown: Float = 0.9f,
    cornerRadius: Float = AppMainRadius,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    rippleColor: Color = MaterialTheme.colorScheme.surface,
    onClick: () -> Unit,
    child: @Composable () -> Unit,
) {

    val interactionSource = remember {
        MutableInteractionSource()
    }

    val coroutineScope = rememberCoroutineScope()

    val scale = remember {
        Animatable(1f)
    }

    Box(
        modifier = modifier
            .height(55.dp)
            .fillMaxWidth()
            .scale(scale = scale.value)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(size = cornerRadius.dp)
            )
            .clip(RoundedCornerShape(size = cornerRadius.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(color = rippleColor)
            ) {
                coroutineScope.launch {
                    scale.animateTo(
                        scaleDown,
                        animationSpec = tween(animationDuration),
                    )
                    scale.animateTo(
                        1f,
                        animationSpec = tween(animationDuration),
                    )
                }
                onClick()
            }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            child()
        }
    }
}
