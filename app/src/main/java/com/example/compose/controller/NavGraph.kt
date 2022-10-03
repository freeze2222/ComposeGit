@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.compose.controller

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.model.nav_model.Screen
import com.example.compose.ui.screens.authScreens.ForgotScreen
import com.example.compose.ui.screens.authScreens.LoginScreen
import com.example.compose.ui.screens.authScreens.RegisterScreen
import com.example.compose.ui.screens.oneTimeScreens.OnBoardScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.OnBoardingScreen.route) {
        composable(route = Screen.OnBoardingScreen.route){
            OnBoardScreen(navController)
        }
        composable(route = Screen.Register.route){
            RegisterScreen()
        }
        composable(route = Screen.Login.route){
            LoginScreen(navController)
        }
        composable(route = Screen.Forgot.route){
            ForgotScreen()
        }
    }
}