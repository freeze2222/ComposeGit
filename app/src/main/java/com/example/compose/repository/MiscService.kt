package com.example.compose.repository

import com.example.compose.model.StreamModel
import com.example.compose.model.data.MainViewModel
import com.example.compose.model.nav_model.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun getStartDestination(isFrame: Boolean): String {
    return if (!isFrame) Screen.Main.route else if (FirebaseAuth.getInstance().currentUser != null) Screen.Mainframe.route else Screen.OnBoardingScreen.route
}

fun watch(data: StreamModel, viewModel: MainViewModel) {
    viewModel.currentStreamId = data.streamId?:"123456"
    viewModel.navController.navigate(Screen.Watch.route)
}

fun getRTMPUrl(currentStreamId: String): String{

    val retrofit = Retrofit.Builder().baseUrl("https://your.api.url/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    val gson = GsonBuilder()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        .create()
    //TODO
    return ""
}