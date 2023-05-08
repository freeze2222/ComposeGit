@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.compose.presentation.navigation

import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.domain.model.nav_model.Screen
import com.example.compose.presentation.items.appScreens.*
import com.example.compose.presentation.items.authScreens.ForgotScreen
import com.example.compose.presentation.items.authScreens.LoginScreen
import com.example.compose.presentation.items.authScreens.RegisterScreen
import com.example.compose.presentation.items.oneTimeScreens.OnBoardScreen
import com.example.compose.repository.getStartDestination
import com.google.accompanist.pager.ExperimentalPagerApi

@RequiresApi(33)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun SetupNavGraph(
    navController: NavHostController? = null,
) {
    // val navController = rememberNavController()
    // viewModel.navController = navController

    NavHost(navController = navController!!, startDestination = getStartDestination(true)) {
        composable(route = Screen.OnBoardingScreen.route) {
            OnBoardScreen(navController)
        }
        composable(route = Screen.Register.route) {
            RegisterScreen(navController)
        }
        composable(route = Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = Screen.Forgot.route) {
            ForgotScreen(navController)
        }
        composable(route = Screen.Main.route) {
            MainScreen(navController)
        }
        composable(route = Screen.SearchVideos.route) {
            SearchVideosScreen(navController)
        }
        composable(route = Screen.SearchStreams.route) {
            SearchStreamsScreen(navController)
        }
        composable(route = Screen.Watch.route) {
            WatchScreen(navController)
        }
        composable(route = Screen.Settings.route) {
            SettingsScreen()
        }

    }
}