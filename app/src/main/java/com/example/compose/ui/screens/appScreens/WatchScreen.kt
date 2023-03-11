package com.example.compose.ui.screens.appScreens

import android.content.pm.ActivityInfo
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.compose.model.api_model.VideoList
import com.example.compose.model.data.MainViewModel
import com.example.compose.repository.changeOrientation
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.VideoPlayer
import java.io.Serializable

@RequiresApi(33)
@Composable
fun WatchScreen(videoUrl: String, viewModel1: Serializable?, viewModel: MainViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Violet
    ) {
        changeOrientation(
            context = LocalContext.current,
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        )
        viewModel.videoList = (viewModel1 as VideoList).data.toMutableList()
        VideoPlayer(videoUrl = videoUrl)
    }
}