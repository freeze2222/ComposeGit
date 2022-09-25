package com.example.compose.ui.screens.nav

sealed class Screen(val route: String){
    object OnBoardingScreen: Screen(route = "OnBoardingScreen")
    object Register: Screen(route = "RegisterScreen")
}