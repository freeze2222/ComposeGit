package com.example.compose.repository

import com.example.compose.model.nav_model.Screen
import com.google.firebase.auth.FirebaseAuth

fun getStartDestination(isFrame: Boolean): String{
    return if (!isFrame) Screen.Main.route else if (FirebaseAuth.getInstance().currentUser!=null) Screen.Mainframe.route else Screen.OnBoardingScreen.route
}