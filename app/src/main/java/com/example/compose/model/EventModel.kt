package com.example.compose.model

import androidx.compose.ui.graphics.painter.Painter

data class EventModel(
    val title: String,
    val description: String,
    val author: String,
    val image: Painter,
    val author_image: Painter
)