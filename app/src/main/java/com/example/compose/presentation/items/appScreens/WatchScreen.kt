package com.example.compose.presentation.items.appScreens

import android.content.pm.ActivityInfo
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose.presentation.items.ErrorItem
import com.example.compose.presentation.items.LoadItem
import com.example.compose.presentation.items.views.VideoPlayer
import com.example.compose.presentation.screen.media.LinkScreenEvent
import com.example.compose.presentation.screen.media.LinkViewModel
import com.example.compose.repository.changeOrientation
import com.example.compose.ui.theme.Violet

@RequiresApi(33)
@Composable
fun WatchScreen(navHostController: NavController) {

    val viewModel = hiltViewModel<LinkViewModel>()

    val state by viewModel.state.collectAsState()

    when {
        state.isLoading -> {
            Log.d("checkData", "Loading...")
            LoadItem()
        }
        state.data.isNotEmpty() -> {
            Log.d("checkData", "data value: ${state.data}")
            WatchScreenContent(navHostController, state.data)
        }
        state.error != null -> {
            Log.d("checkData", "Error ${state.error}")
            ErrorItem(state.error) {
                viewModel.sendEvent(LinkScreenEvent.LoadingData)
            }
        }
    }
}

@RequiresApi(33)
@Composable
fun WatchScreenContent(navHostController: NavController, videoLink: String) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Violet
    ) {
        changeOrientation(
            context = LocalContext.current,
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        )
        val link = remember {
            mutableStateOf("")
        }
        LaunchedEffect(Unit) {
            link.value = videoLink
        }
        if (link.value.isNotEmpty()) {
            VideoPlayer(videoUrl = link.value.strip())
        }

    }
}