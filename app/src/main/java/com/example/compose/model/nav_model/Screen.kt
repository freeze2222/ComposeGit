package com.example.compose.model.nav_model

import com.example.compose.R


sealed class Screen(val route: String, val icon: Int? = null, val title: String? = null){
    object Mainframe : Screen(route = "Mainframe")
    object OnBoardingScreen: Screen(route = "OnBoardingScreen")
    object Register: Screen(route = "RegisterScreen")
    object Login: Screen(route = "LoginScreen")
    object Forgot: Screen(route = "ForgotScreen")
    object Main: Screen(route = "MainScreen", R.drawable.home, "Home")
    object Search: Screen(route = "SearchScreen", R.drawable.magnifying_glass, "Search")
    object Watch: Screen(route = "WatchScreen", R.drawable.video_camera, "Watch")
}