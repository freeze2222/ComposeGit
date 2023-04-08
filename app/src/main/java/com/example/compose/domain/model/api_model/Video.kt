package com.example.compose.domain.model.api_model

import java.io.Serializable

data class Video(
    override val id:String = "",
    val stream_id:String = "",
    val user_login:String = "",
    override val user_name:String = "",
    override val title:String = "",
    val description:String = "",
    val created_at:String = "", //timestamp in RFC3339 format
    val published_at:String = "", //timestamp in RFC3339 format
    val url:String = "",
    override var thumbnail_url:String = "",
    val viewable:String = "",
    override val view_count: Int = 0,
    val language:String = "", //The ISO 639-1 two-letter language code
    val type:String = "",
    val duration:String = "", //ISO 8601 duration format
    override val mediaType: String = "Video",
    override val viewer_count: Int = 0,
):Serializable, Media()

