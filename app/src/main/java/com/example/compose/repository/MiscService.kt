package com.example.compose.repository

import android.app.Activity
import android.content.Context
import android.util.Log
import com.example.compose.model.api_model.Media
import com.example.compose.model.data.MainViewModel
import com.example.compose.model.nav_model.Screen
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


fun getStartDestination(isFrame: Boolean): String {
    return if (!isFrame) Screen.Main.route else if (FirebaseAuth.getInstance().currentUser != null) Screen.Main.route else Screen.OnBoardingScreen.route
}

fun watch(data: Media, viewModel: MainViewModel) {
    Log.e("Debug",data.toString())
    viewModel.isClicked = true
    viewModel.getM3U8Link(
        if (data.mediaType == "Video") data.id else data.user_name,
        data.mediaType
    )

    viewModel.videoScope.invokeOnCompletion {
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.isClicked = false
            viewModel.navController.navigate(route = Screen.Watch.route) {
                popUpTo(Screen.SearchVideos.route)
            }
        }
    }
}

fun changeOrientation(
    context: Context,
    value: Int
) {
    (context as Activity).requestedOrientation = value
}