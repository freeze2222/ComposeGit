package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.compose.controller.SetupNavGraph
import com.example.compose.model.data.MainViewModel
import com.example.compose.model.nav_model.Screen
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.BottomNavigationBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.firebase.database.FirebaseDatabase


@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    private val SELECTED_ITEM_POSITION = "ItemPosition"
    private var mPosition = 0
    private val viewModel = MainViewModel()
    lateinit var navController: NavHostController

    @RequiresApi(33)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Violet
                ) {
                    FirebaseDatabase.getInstance().setPersistenceEnabled(true)
                    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()

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
                                    navController = navController,
                                    viewModel = viewModel
                                )
                                viewModel.navController = navController
                            }
                        }
                    )
                }
            }
        }
    }

}

