package com.example.compose.model.nav_model

sealed class Screen(val route: String){
    object OnBoardingScreen: Screen(route = "OnBoardingScreen")
    object Register: Screen(route = "RegisterScreen")
    object Login: Screen(route = "LoginScreen")
    object Forgot: Screen(route = "ForgotScreen")
}