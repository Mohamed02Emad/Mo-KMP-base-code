package com.mo.newbase.android.features.setup.onBoarding.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerIndicator(
    count: Int,
    pagerState: PagerState,
    activeLineWidth: Dp = 32.dp,
    width: Dp = 12.dp,
    activeColor: Color = MaterialTheme.colorScheme.primary,
    notActiveColor: Color = Color.LightGray,
    @Suppress("MagicNumber")
    circleSpacing: Dp = (width.value * 0.5).dp,
    height: Dp = width,
    totalWidth: Dp = activeLineWidth + ((count - 1) * width) + ((count - 1) * circleSpacing),
) {
    Canvas(modifier = Modifier.width(width = totalWidth)) {
        val spacing = circleSpacing.toPx()
        val dotWidth = width.toPx()
        val dotHeight = height.toPx()

        val activeDotWidth = activeLineWidth.toPx()
        var x = 0f
        val y = center.y

        repeat(count) { i ->
            val posOffset = pagerState.pageOffset
            val dotOffset = posOffset % 1
            val current = posOffset.toInt()
            val currentPageOffset = pagerState.currentPageOffsetFraction.absoluteValue

            val factor = (dotOffset * (activeDotWidth - dotWidth))
            val color = getColor(
                i,
                current,
                activeDotWidth,
                factor,
                dotWidth,
                activeColor,
                currentPageOffset,
                notActiveColor,
            )

            val calculatedWidth =
                getCalculatedWidth(i, current, activeDotWidth, factor, currentPageOffset, dotWidth)

            drawIndicator(
                x,
                y,
                calculatedWidth,
                dotHeight,
                CornerRadius(height.value * 2),
                notActiveColor,
                color,
            )
            x += calculatedWidth + spacing
        }
    }
}

private fun getColor(
    i: Int,
    current: Int,
    activeDotWidth: Float,
    factor: Float,
    dotWidth: Float,
    activeColor: Color,
    currentPageOffset: Float,
    notActiveColor: Color,
) = when {
    i == current -> {
        val currentWidth = activeDotWidth - factor
        Color(
            alpha = (currentWidth - dotWidth) / (activeDotWidth - dotWidth),
            red = activeColor.red,
            green = activeColor.green,
            blue = activeColor.blue,
        )
    }

    i - 1 == current && currentPageOffset > 0 -> {
        val nextWidth = dotWidth + factor
        Color(
            alpha = (nextWidth - dotWidth) / (activeDotWidth - dotWidth),
            red = activeColor.red,
            green = activeColor.green,
            blue = activeColor.blue,
        )
    }

    else -> {
        notActiveColor
    }
}

private fun getCalculatedWidth(
    i: Int,
    current: Int,
    activeDotWidth: Float,
    factor: Float,
    currentPageOffset: Float,
    dotWidth: Float,
) = when {
    i == current -> {
        val currentWidth = activeDotWidth - factor
        currentWidth
    }

    i - 1 == current && currentPageOffset > 0 -> {
        val nextWidth = dotWidth + factor
        nextWidth
    }

    else -> {
        dotWidth
    }
}

private fun DrawScope.drawIndicator(
    x: Float,
    y: Float,
    width: Float,
    height: Float,
    radius: CornerRadius,
    colorNotActive: Color = Color.LightGray,
    color: Color = Color.LightGray,
) {
    val rect = RoundRect(
        x,
        y - height / 2,
        x + width,
        y + height / 2,
        radius,
    )
    val path1 = Path().apply { addRoundRect(rect) }
    drawPath(path = path1, color = colorNotActive)
    val path2 = Path().apply { addRoundRect(rect) }
    drawPath(path = path2, color = color)
}

@OptIn(ExperimentalFoundationApi::class)
val PagerState.pageOffset: Float
    get() = this.currentPage + this.currentPageOffsetFraction




