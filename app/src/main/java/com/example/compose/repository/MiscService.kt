package com.example.compose.repository

import com.example.compose.model.api_model.Stream
import com.example.compose.model.data.MainViewModel
import com.example.compose.model.nav_model.Screen
import com.google.firebase.auth.FirebaseAuth


fun getStartDestination(isFrame: Boolean): String {
    return if (!isFrame) Screen.Main.route else if (FirebaseAuth.getInstance().currentUser != null) Screen.Mainframe.route else Screen.OnBoardingScreen.route
}

fun watch(data: Stream, viewModel: MainViewModel) {
    viewModel.currentStreamerName = data.user_name
    viewModel.navController.navigate(Screen.Watch.route)
}