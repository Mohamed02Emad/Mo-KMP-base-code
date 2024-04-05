package com.mo.newbase.android.features.setup.onBoarding.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import bounceClick

@Composable
fun OnboardingNextButton(
    onClick: () -> Unit,
) {
    val shape = CircleShape
    Box(
        modifier = Modifier
            .height(55.dp)
            .wrapContentWidth()
            .clip(shape)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 350,
                    easing = LinearEasing,
                ),
            )
            .bounceClick(shape)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.CenterEnd,
    ) {
        NextButton(shape)
    }
}

@Composable
private fun NextButton(shape: RoundedCornerShape) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(shape)
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.CenterEnd,
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowForward,
            contentDescription = "Next",
            tint = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .size(40.dp)
                .padding(10.dp),
        )
    }
}
