@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.compose.controller

import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.presentation.screen.main.MainViewModel
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
    viewModel: MainViewModel,
) {
    // val navController = rememberNavController()
    // viewModel.navController = navController

    NavHost(navController = navController!!, startDestination = getStartDestination(true)) {
        composable(route = Screen.OnBoardingScreen.route) {
            OnBoardScreen(navController)
        }
        composable(route = Screen.Register.route) {
            RegisterScreen(viewModel, navController)
        }
        composable(route = Screen.Login.route) {
            LoginScreen(navController, viewModel)
        }
        composable(route = Screen.Forgot.route) {
            ForgotScreen()
        }
        composable(route = Screen.Main.route) {
            MainScreen(viewModel)
        }
        composable(route = Screen.SearchVideos.route) {
            SearchVideosScreen(viewModel)
        }
        composable(route = Screen.SearchStreams.route){
            SearchStreamsScreen(viewModel = viewModel)
        }
        composable(route = Screen.Watch.route) {
            WatchScreen(viewModel)
        }

        composable(route = Screen.Settings.route){
            SettingsScreen()
        }
    }
}