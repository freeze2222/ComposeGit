package com.example.compose.ui.screen

sealed class Screen(val route: String){
    object OnBoardingScreen: Screen(route = "OnBoardingScreen")
    object Register: Screen(route = "RegisterScreen")
}