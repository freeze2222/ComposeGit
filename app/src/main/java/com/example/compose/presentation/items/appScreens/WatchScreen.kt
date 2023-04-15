package com.example.compose.presentation.items.appScreens

import android.content.pm.ActivityInfo
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.compose.presentation.items.views.VideoPlayer
import com.example.compose.repository.changeOrientation
import com.example.compose.ui.theme.Violet

@RequiresApi(33)
@Composable
fun WatchScreen(videoLink:String) {
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
        if (link.value.isNotEmpty()){
            VideoPlayer(videoUrl = link.value.strip())
        }

    }
}