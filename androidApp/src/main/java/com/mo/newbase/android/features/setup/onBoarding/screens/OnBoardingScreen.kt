package com.mo.newbase.android.features.setup.onBoarding.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mo.newbase.android.R
import com.mo.newbase.android.core.composables.VSpace
import com.mo.newbase.android.features.setup.onBoarding.composables.LogoLayout
import com.mo.newbase.android.features.setup.onBoarding.composables.OnBoardingButtonsLayout
import com.mo.newbase.android.features.setup.onBoarding.composables.OnBoardingPage
import com.mo.newbase.features.onBoarding.presentation.OnBoardingViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel,
    navController: NavHostController,
) {

    val onBoardings = listOf<Pair<Int, Int>>(
        R.string.on_boarding1 to R.drawable.onboarding1,
        R.string.on_boarding2 to R.drawable.onboarding2,
        R.string.on_boarding3 to R.drawable.onboarding3,
    )
    //for fcm
//    val scope = rememberCoroutineScope()
//    scope.launch {
//        val token = getDeviceToken()
//        viewModel.setDeviceToken(token)
//    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val pagerState = rememberPagerState { onBoardings.size }
        Column {
            VSpace(height = 20.dp)
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                LogoLayout()
            }
            HorizontalPager(
                state = pagerState
            ) { index ->
                val onBoard = onBoardings[index]
                OnBoardingPage(
                    modifier = Modifier.fillMaxSize(),
                    image = onBoard.second,
                    text = LocalContext.current.getString(onBoard.first)
                )
            }
        }
        OnBoardingButtonsLayout(pagerState = pagerState, pagesCount = onBoardings.size) {
            viewModel.setOnBoardingFinished()
//                navController.replaceStartDestination(Auth_LOGIN_ROUTE.name)
        }
    }
}