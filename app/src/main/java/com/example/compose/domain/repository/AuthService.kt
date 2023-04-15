package com.example.compose.repository

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.compose.domain.model.nav_model.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.userProfileChangeRequest

fun login(
    navController: NavController,
    email: String,
    password: String,
    context: Context
) {
    val auth = FirebaseAuth.getInstance()
    if (email.isNotBlank() && password.isNotBlank()) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
            navController.navigate(Screen.Main.route) {
                popUpTo(Screen.Login.route) { inclusive = true }
            }
        }.addOnFailureListener {
            Toast.makeText(context, "Неверные данные", Toast.LENGTH_SHORT).show()
        }
    } else {
        Toast.makeText(context, "Заполните все поля", Toast.LENGTH_SHORT).show()
    }
}

fun createAccount(
    navController: NavHostController,
    username: String,
    email: String,
    password: String,
    context: Context
) {
    val auth = FirebaseAuth.getInstance()
    auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
        val user = auth.currentUser
        val profileUpdates = userProfileChangeRequest {
            displayName = username
        }
        user!!.updateProfile(profileUpdates)
        auth.updateCurrentUser(user).addOnSuccessListener {
            login(navController, email, password, context)
        }

    }
}

fun getUser(): FirebaseUser? {
    return FirebaseAuth.getInstance().currentUser
}