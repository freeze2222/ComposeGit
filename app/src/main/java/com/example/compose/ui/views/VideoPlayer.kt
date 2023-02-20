package com.example.compose.ui.views

import android.net.Uri
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

@Composable
fun VideoPlayer(videoUrl: String) {
    val mContext = LocalContext.current
    val mExoPlayer = remember(mContext) {
        ExoPlayer.Builder(mContext)
            .build().apply {
                val mediaItem = MediaItem.Builder()
                    .setUri(Uri.parse(videoUrl.lowercase()))
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
            }
        }, modifier = Modifier.clip(RoundedCornerShape(16.dp)))
    ) {
        onDispose {
            mExoPlayer.release()
        }
    }
}

