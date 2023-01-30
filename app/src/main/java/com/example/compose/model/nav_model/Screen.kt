package com.example.compose.model.nav_model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Screen(val route: String, val icon: ImageVector? = null, val title: String? = null){
    object Mainframe : Screen(route = "Mainframe")
    object OnBoardingScreen: Screen(route = "OnBoardingScreen")
    object Register: Screen(route = "RegisterScreen")
    object Login: Screen(route = "LoginScreen")
    object Forgot: Screen(route = "ForgotScreen")
    object Main: Screen(route = "MainScreen", Icons.Default.Home, "Home") //TODO
}