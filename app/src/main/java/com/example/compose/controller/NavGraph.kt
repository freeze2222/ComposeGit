@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.compose.controller

import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.model.data.MainViewModel
import com.example.compose.model.nav_model.Screen
import com.example.compose.repository.getStartDestination
import com.example.compose.ui.screens.appScreens.*
import com.example.compose.ui.screens.authScreens.ForgotScreen
import com.example.compose.ui.screens.authScreens.LoginScreen
import com.example.compose.ui.screens.authScreens.RegisterScreen
import com.example.compose.ui.screens.oneTimeScreens.OnBoardScreen
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
        composable(route = Screen.Search.route) {
            SearchScreen(viewModel)
        }
        composable(route = Screen.Video.route) {
            LiveListScreen(viewModel)
        }
        composable(route = Screen.Watch.route) {
            WatchScreen(viewModel)
        }

        composable(route = Screen.Settings.route){
            SettingsScreen()
        }
    }
}