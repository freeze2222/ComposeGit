package com.example.compose.model.api_model

data class Video(
    val id:String = "",
    val stream_id:String = "",
    val user_login:String = "",
    val user_name:String = "",
    val title:String = "",
    val description:String = "",
    val created_at:String = "", //timestamp in RFC3339 format
    val published_at:String = "", //timestamp in RFC3339 format
    val url:String = "",
    var thumbnail_url:String = "",
    val viewable:String = "",
    val view_count: Int = 0,
    val language:String = "", //The ISO 639-1 two-letter language code
    val type:String = "",
    val duration:String = "", //ISO 8601 duration format
)

