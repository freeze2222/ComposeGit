package com.example.compose.ui.views

import android.util.Log
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.compose.model.data.MainViewModel
import androidx.compose.ui.platform.LocalDensity

@Composable
fun WebView(viewModel: MainViewModel) {
    val configuration = LocalConfiguration.current

    val screenHeightDp = configuration.screenHeightDp.dp
    val screenWidthDp = configuration.screenWidthDp.dp
    val screenHeightPx = LocalDensity.current.run { screenHeightDp.toPx() }
    val screenWidthPx = LocalDensity.current.run { screenWidthDp.toPx() }
    val channelName = viewModel.currentStreamerName
    val mUrl =
        "https://player.twitch.tv/?parent=twitch.tv&channel=${channelName}&height=${screenHeightPx}&width=${screenWidthPx}"
    Log.e("Debug",mUrl)
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            setBackgroundColor(0x00000000)
            loadUrl(mUrl)
        }

    }, update = {
        it.loadUrl(mUrl)
    })
}