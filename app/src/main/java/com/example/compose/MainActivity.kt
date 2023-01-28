package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.controller.SetupNavGraph
import com.example.compose.model.data.MainViewModel
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.ui.theme.Violet
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Violet
                ) {
                    FirebaseApp.initializeApp(LocalContext.current)
                    FirebaseDatabase.getInstance().setPersistenceEnabled(true)
                    val viewModel = MainViewModel()
                    navController = rememberNavController()
                    SetupNavGraph(navController = navController, viewModel)
                }
            }
        }
    }
}
