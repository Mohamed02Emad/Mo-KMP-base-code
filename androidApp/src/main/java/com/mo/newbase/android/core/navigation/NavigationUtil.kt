package com.mo.newbase.android.core.navigation

import androidx.navigation.NavController
import com.mo.newbase.core.navigation.Screen

fun NavController.push(
    screen: Screen,
    popUpTo: String? = null,
    inclusive: Boolean = false
) {
    val route = when (screen) {
//        is Screen.NotificationDetails -> screen.createRoute(screen.id ?: -1)
        else -> screen.route
    }

    navigate(route) {
        if (popUpTo != null) {
            val popUpToDestination = graph.findNode(popUpTo) ?: error("Navigation destination not found: $popUpTo")
            popBackStack(
                popUpToDestination.id,
                inclusive = inclusive
            )
        }
    }
}

fun NavController.pop() {
    this.navigateUp()
}

fun NavController.popToStart() {
    val startDestination = this.graph.startDestinationId
    this.popBackStack(startDestination, false)
}

fun NavController.pushReplace(
    screen : Screen,
){
    this.popBackStack()
    push(screen)
}

fun NavController.clearBackStack() {
    popBackStack(graph.startDestinationId, inclusive = false)
}

/**
 * can work with no arg screens only
 * */
fun NavController.replaceStartDestination(screen: Screen) {
    val startDestination = this.graph.startDestinationRoute!!
    this.navigate(
        screen.route,
        builder = {
        popUpTo(startDestination) {
            inclusive = true
        }
    })
    this.graph.setStartDestination(screen.route)
}
