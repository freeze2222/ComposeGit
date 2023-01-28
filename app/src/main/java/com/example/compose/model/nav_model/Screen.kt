package com.example.compose.model.nav_model


sealed class Screen(val route: String,val icon : Int? = null,val title : String? = null){
    object Mainframe : Screen(route = "Mainframe")
    object OnBoardingScreen: Screen(route = "OnBoardingScreen")
    object Register: Screen(route = "RegisterScreen")
    object Login: Screen(route = "LoginScreen")
    object Forgot: Screen(route = "ForgotScreen")
    object Frame : Screen(route = "FrameScreen")
    object Main: Screen(route = "MainScreen") //TODO
}