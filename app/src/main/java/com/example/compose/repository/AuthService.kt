package com.example.compose.repository

import android.content.Context
import android.widget.Toast
import com.example.compose.model.data.MainViewModel
import com.example.compose.model.nav_model.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.userProfileChangeRequest

fun login(
    viewModel: MainViewModel,
    email: String,
    password: String,
    context: Context
) {
    val auth = FirebaseAuth.getInstance()
    if (email.isNotBlank()&&password.isNotBlank()) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
            viewModel.navController.navigate(Screen.Main.route) {
                popUpTo(Screen.Login.route) { inclusive = true }
            }
        }.addOnFailureListener {
            Toast.makeText(context, "Неверные данные", Toast.LENGTH_SHORT).show()
        }
    }else{
        Toast.makeText(context, "Заполните все поля", Toast.LENGTH_SHORT).show()
    }
}

fun createAccount(
    viewModel: MainViewModel,
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
            viewModel.user = user
            login(viewModel, email, password, context)
        }

    }
}

fun getUser(): FirebaseUser? {
    return FirebaseAuth.getInstance().currentUser
}