package com.example.compose.model.nav_model

import com.example.compose.R


sealed class Screen(val route: String, val icon: Int? = null, val title: String? = null){
    object OnBoardingScreen: Screen(route = "OnBoardingScreen")
    object Register: Screen(route = "RegisterScreen")
    object Login: Screen(route = "LoginScreen")
    object Forgot: Screen(route = "ForgotScreen")
    object Video: Screen(route = "VideoScreen")
    object Main: Screen(route = "MainScreen", R.drawable.home, "Home")
    object SearchVideos: Screen(route = "SearchVideosScreen", R.drawable.magnifying_glass, "Videos")
    object SearchStreams: Screen(route = "SearchStreamsScreen", R.drawable.video_camera, "Streams")
    object Settings: Screen(route = "SettingsScreen", R.drawable.settings, "Settings")
    object Watch: Screen(route = "Watch")
}