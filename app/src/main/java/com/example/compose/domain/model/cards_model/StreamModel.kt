package com.example.compose.domain.model.cards_model

import androidx.compose.ui.graphics.painter.Painter

data class StreamModel(
    val streamId:String?,
    val preview: Painter?,
    val viewers: String,
    val channel_name:String,
    val channel_image:Painter?,
    val title:String
)