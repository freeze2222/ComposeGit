package com.example.compose.repository

import android.app.Activity
import android.content.Context
import androidx.navigation.NavController
import com.example.compose.data.DomainRepositoryImpl
import com.example.compose.domain.model.api_model.Media
import com.example.compose.domain.model.nav_model.Screen
import com.google.firebase.auth.FirebaseAuth


fun getStartDestination(isFrame: Boolean): String {
    return if (!isFrame) Screen.Main.route else if (FirebaseAuth.getInstance().currentUser != null) Screen.Main.route else Screen.OnBoardingScreen.route
}

fun watch(data: Media, navController: NavController) {
    val link = DomainRepositoryImpl().getM3U8Link(
        if (data.mediaType == "Video") data.id else data.user_name,
        data.mediaType
    )
    //viewModel.isClicked = false TODO
    navController.navigate(route = Screen.Watch.route) {
        popUpTo(Screen.SearchVideos.route)
    }

}

fun changeOrientation(
    context: Context,
    value: Int
) {
    (context as Activity).requestedOrientation = value
}