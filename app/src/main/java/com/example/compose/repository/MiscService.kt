package com.example.compose.repository

import android.app.Activity
import android.content.Context
import com.example.compose.model.api_model.Video
import com.example.compose.model.data.MainViewModel
import com.example.compose.model.nav_model.Screen
import com.google.firebase.auth.FirebaseAuth


fun getStartDestination(isFrame: Boolean): String {
    return if (!isFrame) Screen.Main.route else if (FirebaseAuth.getInstance().currentUser != null) Screen.Main.route else Screen.OnBoardingScreen.route
}

fun watch(data: Video, viewModel: MainViewModel) {
    viewModel.getM3U8Link(data.id)
        viewModel.navController.navigate(Screen.Watch.route) {
            popUpTo(Screen.Search.route)
        }
}

fun changeOrientation(
    context: Context,
    value: Int
) {
    (context as Activity).requestedOrientation = value
}