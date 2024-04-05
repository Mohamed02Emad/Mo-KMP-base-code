package com.mo.newbase.android.core.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.swipeTransitionComposable(
    route: String,
    arguments : List<NamedNavArgument> = emptyList(),
    scope: @Composable (NavBackStackEntry) -> Unit,
) {
    composable(
        route,
        arguments = arguments,
        exitTransition = {
            return@composable slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Start, tween(500)
            )
        }, enterTransition = {
            return@composable slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.End, tween(500)
            )
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center,
        ) {
            scope(it)
        }
    }
}

@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.fadeTransitionComposable(
    route: String,
    arguments : List<NamedNavArgument> = emptyList(),
    scope: @Composable (NavBackStackEntry) -> Unit,
) {
    composable(
        route,
        arguments = arguments,
        exitTransition = {
            return@composable fadeOut(tween(600))
        }, enterTransition = {
            return@composable fadeIn(tween(600))
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center,
        ) {
            scope(it)
        }
    }
}