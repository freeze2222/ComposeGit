package com.example.compose.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

fun login(){

}

fun getUser(): FirebaseUser? {
    return FirebaseAuth.getInstance().currentUser
}