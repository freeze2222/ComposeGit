package com.example.compose.repository

import android.util.Log
import androidx.navigation.NavController
import com.example.compose.model.data.MainViewModel
import com.example.compose.model.nav_model.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

fun login(
    viewModel: MainViewModel,
    username: String,
    password: String
) {
    Log.e("DEBUG","USERNAME:${username},PASSWORD:${password}")
    viewModel.navController.navigate(Screen.Main.route)
}

fun createAccount(
    viewModel: MainViewModel,
    navController: NavController,
    value: String,
    value1: String,
    value2: String
) {

}

fun getUser(): FirebaseUser? {
    return FirebaseAuth.getInstance().currentUser
}