package com.mo.newbase.android.core.navigation

import androidx.navigation.NavController

fun NavController.navigateWithArgs(
    screen: Screen,
    args: Map<String, Any?> = emptyMap(),
    popUpTo: String? = null,
    inclusive: Boolean = false
) {
    val route = when (screen) {
        is Screen.Detail -> screen.createRoute(args["id"] as Int)
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
    args: Map<String, Any?>? = null,
){
    this.popBackStack()
    args?.let {
        navigateWithArgs(screen, args)
    }?:run {
        this.navigate(screen.route)
    }
}

fun NavController.clearBackStack() {
    popBackStack(graph.startDestinationId, inclusive = false)
}

/**
* can work with no arg screens only
* */
fun NavController.replaceStartDestination(screen: Screen) {
    val startDestination = this.graph.startDestinationRoute!!
    this.navigate(screen.route, builder = {
        popUpTo(startDestination) {
            inclusive = true
        }
    })
    this.graph.setStartDestination(screen.route)
}
