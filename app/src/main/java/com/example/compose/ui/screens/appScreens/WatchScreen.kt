package com.example.compose.ui.screens.appScreens

import android.content.pm.ActivityInfo
import android.util.Log
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
import com.google.gson.Gson

@RequiresApi(33)
@Composable
fun WatchScreen(videoUrl: String, viewModel1: String, viewModel: MainViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Violet
    ) {
        changeOrientation(
            context = LocalContext.current,
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        )
        val videoList = Gson().fromJson(viewModel1,Array<VideoList>::class.java)
        viewModel.videoList =videoList[0].data.toMutableList()
        Log.e("Lister", videoList[0].data.toMutableList().toString())
        VideoPlayer(videoUrl = videoUrl)
    }
}