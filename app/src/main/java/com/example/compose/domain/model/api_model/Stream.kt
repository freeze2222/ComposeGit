package com.example.compose.domain.model.api_model

import java.io.Serializable



data class Stream(
    val user_id: String,
    val user_login: String,
    override val user_name: String,
    val game_id: Int,
    val game_name: String,
    val type: String,
    override val title: String,
    override var viewer_count: Int,
    val startedAt: String,
    val language: String,
    override var thumbnail_url: String,
    val tag_ids: Array<String>,
    val tags: Array<String>,
    val is_mature: Boolean,
    override val id: String,
    override var mediaType: String = "Stream",
    override var view_count: Int = 0,
) : Serializable, Media()
