package com.example.compose.ui.screens.appScreens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.controller.SetupNavGraph
import com.example.compose.model.data.MainViewModel


@Composable
fun FrameScreen(mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    SetupNavGraph(navController = navController, navFrameController = navController, true, mainViewModel)
}