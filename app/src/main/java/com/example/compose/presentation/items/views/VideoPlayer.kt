package com.example.compose.presentation.items.views

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun VideoPlayer(videoUrl: String) {
    Log.e("DebugURL", videoUrl)
    val mContext = LocalContext.current
    val mExoPlayer = remember(mContext) {
        ExoPlayer.Builder(mContext)
            .build().apply {
                val mediaItem = MediaItem.Builder()
                    .setUri(videoUrl)
                    .build()
                setMediaItem(mediaItem)
                playWhenReady = true
                prepare()
            }
    }

    DisposableEffect(
        AndroidView(factory = { context ->
            StyledPlayerView(context).apply {
                player = mExoPlayer
                setShowBuffering(StyledPlayerView.SHOW_BUFFERING_ALWAYS)
            }
        }, modifier = Modifier.clip(RoundedCornerShape(16.dp)))
    ) {
        onDispose {
            mExoPlayer.release()
        }
    }
}

