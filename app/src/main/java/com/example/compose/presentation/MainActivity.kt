package com.example.compose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.compose.domain.model.nav_model.Screen
import com.example.compose.presentation.navigation.SetupNavGraph
import com.example.compose.presentation.screen.main.MainViewModel
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.BottomNavigationBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    private val viewModel : MainViewModel by viewModels()

    @RequiresApi(33)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true)
            val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()

            ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Violet
                ) {
                    when (navBackStackEntry?.destination?.route) {
                        Screen.Main.route -> {
                            bottomBarState.value = true
                        }
                        Screen.Video.route -> {
                            bottomBarState.value = false
                        }
                        Screen.OnBoardingScreen.route -> {
                            bottomBarState.value = false
                        }
                        Screen.Login.route -> {
                            bottomBarState.value = false
                        }
                        Screen.Main.route -> {
                            bottomBarState.value = true
                        }
                        Screen.Watch.route -> {
                            bottomBarState.value = false
                        }
                        Screen.SearchVideos.route -> {
                            bottomBarState.value = true
                        }
                        Screen.SearchStreams.route -> {
                            bottomBarState.value = true
                        }
                    }
                    Scaffold(
                        topBar = {},
                        bottomBar = {
                            BottomNavigationBar(
                                navController,
                                bottomBarState = bottomBarState
                            )
                        },
                        content = { padding ->
                            Box(modifier = Modifier.padding(padding)) {
                                SetupNavGraph(
                                    navController = navController
                                )
                            }
                        }
                    )
                }
            }
        }
    }

}

