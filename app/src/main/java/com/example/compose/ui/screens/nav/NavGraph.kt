@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.compose.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.ui.screens.authScreens.OnBoardScreen
import com.example.compose.ui.screens.authScreens.RegisterScreen
import com.example.compose.ui.screens.nav.Screen
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
    }
}