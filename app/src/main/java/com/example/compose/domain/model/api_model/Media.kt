package com.example.compose.domain.model.api_model

abstract class Media {
    abstract val user_name: String
    abstract val id: String
    abstract val mediaType: String
    abstract val thumbnail_url: String
    abstract val view_count: Int
    abstract val viewer_count: Int
    abstract val title: String
}