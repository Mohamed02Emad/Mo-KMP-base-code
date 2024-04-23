package com.mo.newbase.android.core.navigation.navhosts

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mo.newbase.core.navigation.Screen
import com.mo.newbase.android.core.navigation.fadeTransitionComposable
import com.mo.newbase.android.features.setup.onBoarding.screens.OnBoardingScreen
import com.mo.newbase.features.more.settings.presentation.SettingsViewModel
import com.mo.newbase.features.onBoarding.presentation.OnBoardingViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun NavHost(startDestination: Screen?, settingsViewModel: SettingsViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination?.route ?: Screen.OnBoarding.route
    ) {

        fadeTransitionComposable(
            route = Screen.OnBoarding.route
        ) {
            val viewModel: OnBoardingViewModel = getViewModel()
            OnBoardingScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

 // working
//        swipeTransitionComposable(
//            route = Screen.NotificationDetails().route,
//        ) {
//            val id = it.arguments?.getString("id") ?: "-1"
//            NotificationDetailsScreen(
//                navController = navController,
//                id = id.toInt()
//            )
//        }

        //not working
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
