package com.mo.newbase.android.features.setup.onBoarding.composables

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mo.newbase.android.R
import com.mo.newbase.android.core.composables.IfOrNope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingButtonsLayout(
    pagerState: PagerState,
    pagesCount: Int,
    onFinishedOnBoarding: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, bottom = 20.dp)
            .padding(horizontal = 16.dp),
    ) {
        Spacer(modifier = Modifier.weight(1F))
        Row(
            modifier = Modifier
                .padding(bottom = 40.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            PagerIndicator(count = pagesCount, pagerState = pagerState)
        }
        ButtonsRow(
            pagerState = pagerState,
            pagesCount = pagesCount,
            onFinishedOnBoarding = onFinishedOnBoarding
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ButtonsRow(pagerState: PagerState, pagesCount: Int, onFinishedOnBoarding: () -> Unit) {
    val currentPage = pagerState.currentPage
    val showNext = currentPage <= pagesCount - 1
    val isLastPage = currentPage == pagesCount - 1
    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        SkipButton {
            onFinishedOnBoarding.invoke()
        }

        Box {}

        IfOrNope(showNext) {
            NextButton(
                pagerState = pagerState,
                coroutineScope = coroutineScope,
                isLastPage = isLastPage,
                onFinishedOnBoarding = onFinishedOnBoarding
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun NextButton(
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
    onFinishedOnBoarding: () -> Unit,
    isLastPage: Boolean,
) {
    OnboardingNextButton {
        if (isLastPage) {
            onFinishedOnBoarding()
        } else {
            coroutineScope.launch {
                pagerState.animateScrollToPage(
                    page = pagerState.currentPage + 1,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMediumLow,
                    )
                )
            }
        }
    }
}

@Composable
private fun SkipButton(onFinishedOnBoarding: () -> Unit) {
    OnBoardingButton(
        modifier = Modifier,
        backgroundColor = Color.Transparent,
        onClick = {
            onFinishedOnBoarding()
        }
    ) {
        Text(
            text = LocalContext.current.getString(R.string.skip),
            style = TextStyle(
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 14.sp
            )
        )
    }
}

