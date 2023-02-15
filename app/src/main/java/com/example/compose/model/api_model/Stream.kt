package com.example.compose.model.api_model

data class Stream(
    val id: String,
    val user_id:String,
    val user_login:String,
    val user_name:String,
    val game_id:Int,
    val game_name:String,
    val type:String,
    val title:String,
    val viewerCount:Int,
    val startedAt:String,
    val language:String,
    var thumbnail_url:String,
    val tag_ids:Array<String>,
    val tags:Array<String>,
    val is_mature:Boolean
)
