package com.mo.newbase.android.core.navigation

sealed class Screen(val route: String) {
    //example of arguments
    data class Detail(val id: Int) : Screen("detail/{id}") {
        fun createRoute(id: Int): String = route.replace("{id}", id.toString())
    }
    data object OnBoarding : Screen("onBoarding")
    data object Home : Screen("home")
}