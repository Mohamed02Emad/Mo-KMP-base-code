package com.mo.newbase.core.navigation

sealed class Screen(val route: String) {
    //example of arguments
//    data class Detail(val id: Int) : Screen("detail/{id}") {
//        fun createRoute(id: Int): String = route.replace("{id}", id.toString())
//    }



    data object OnBoarding : Screen("onBoarding")
    data object Login : Screen("login")
    data object Register : Screen("register")
    data object Home : Screen("home")
}