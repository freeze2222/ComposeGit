package com.example.compose.model.data

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser

class MainViewModel : ViewModel() {
    lateinit var currentUser: FirebaseUser
}