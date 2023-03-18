package com.example.compose.ui.screens.appScreens

import android.content.pm.ActivityInfo
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.compose.model.data.MainViewModel
import com.example.compose.model.nav_model.Screen
import com.example.compose.repository.changeOrientation
import com.example.compose.ui.theme.Violet

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun WatchHandler(viewModel: MainViewModel) {
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

        if (link.value.isEmpty()) {
            if (viewModel.videoLink.isNotBlank()){
                link.value = viewModel.videoLink
                viewModel.navController.navigate("${Screen.Watch.route}?link=${viewModel.videoLink}")
            }
        }

    }
}