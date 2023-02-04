package com.example.compose.model

import androidx.compose.ui.graphics.painter.Painter

data class StreamModel(
    val stream:String?,
    val preview: Painter?,
    val viewers: String,
    val channel_name:String,
    val channel_image:Painter?
)