package com.example.compose.ui.screens.appScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.compose.controller.SetupNavGraph
import com.example.compose.model.data.MainViewModel
import com.example.compose.ui.theme.LightGrey
import com.example.compose.ui.views.BottomNavigationBar
import com.google.firebase.auth.FirebaseAuth

@Composable
fun MainframeScreen(viewModel: MainViewModel) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {},
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                viewModel.currentUser = FirebaseAuth.getInstance().currentUser!!
                SetupNavGraph(
                    navController = navController,
                    null,
                    false,
                    viewModel
                )
            }
        },
        backgroundColor = LightGrey
    )
}