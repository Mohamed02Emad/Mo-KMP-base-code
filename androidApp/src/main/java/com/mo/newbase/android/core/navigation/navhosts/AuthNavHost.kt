package com.mo.newbase.android.core.navigation.navhosts

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mo.newbase.android.core.navigation.Screen
import com.mo.newbase.android.core.navigation.fadeTransitionComposable
import com.mo.newbase.android.features.setup.onBoarding.screens.OnBoardingScreen
import com.mo.newbase.features.onBoarding.presentation.OnBoardingViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AuthNavHost(startDestination: Screen) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination.route
    ) {

        this.fadeTransitionComposable(
            route = Screen.OnBoarding.route
        ) {
            val viewModel: OnBoardingViewModel = getViewModel()
            OnBoardingScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

//        this.fadeTransitionComposable(
//            route = ,
//            arguments = listOf(navArgument("params") {
//                type = NavType.StringType
//            }),
//
//            ) {
//            val viewModel: ResetPasswordViewModel = getViewModel()
//            val args = handleArgs<ResetPasswordScreenArgs>(it)
//            ResetPasswordScreen(
//                viewModel = viewModel,
//                navController = navController,
//                args = args
//            )
//        }
    }
}
