package com.example.compose.model.data

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseUser

class MainViewModel : ViewModel() {
    lateinit var currentUser: FirebaseUser
    lateinit var navController : NavHostController
}