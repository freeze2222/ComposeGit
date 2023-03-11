package com.example.compose.model.api_model

import java.io.Serializable

data class VideoList(
    val data: MutableList<Video>
) : Serializable
