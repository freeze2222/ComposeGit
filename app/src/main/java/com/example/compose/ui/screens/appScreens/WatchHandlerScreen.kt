package com.example.compose.ui.screens.appScreens

import android.content.pm.ActivityInfo
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.compose.model.api_model.Video
import com.example.compose.model.data.MainViewModel
import com.example.compose.model.nav_model.Screen
import com.example.compose.repository.changeOrientation
import com.example.compose.ui.theme.Violet
import com.example.compose.ui.views.VideoPlayer
import com.google.gson.Gson

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
                VideoPlayer(videoUrl = link.value)
                val list = mutableListOf<Video>()
                viewModel.videoList.forEach {
                    Log.e("FOREACH",it.toString())
                    list.add(it)
                }
                val videoList = Gson().toJson(list)
                Log.e("list",videoList)
                viewModel.navController.navigate("${Screen.Watch.route}?link=${viewModel.videoLink}&list=${videoList}")
            }
        }

    }
}