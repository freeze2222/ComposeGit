package com.example.compose.ui.screens.appScreens

import android.content.pm.ActivityInfo
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.compose.model.data.MainViewModel
import com.example.compose.repository.changeOrientation
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.VideoPlayer

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun WatchScreen(viewModel: MainViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Violet
    ) {
        changeOrientation(
            context = LocalContext.current,
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        )

        Log.e("DEBUGFINAL",viewModel.videoLink)
        VideoPlayer(videoUrl = viewModel.videoLink)
    }
}