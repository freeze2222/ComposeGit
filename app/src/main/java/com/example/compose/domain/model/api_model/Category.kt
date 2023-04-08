package com.example.compose.domain.model.api_model

data class Category(
    val broadcaster_language:String, // ISO 639-1 two-letter language code
    val broadcaster_login:String,
    val display_name:String,
    val game_id:String,
    val game_name:String,
    val id:String,
    val is_live:Boolean,
    val tags:Array<String>,
    var thumbnail_url:String,
    val title:String,
    val started_at:String //UTC date and time (in RFC3339 format)
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Category

        if (broadcaster_language != other.broadcaster_language) return false
        if (broadcaster_login != other.broadcaster_login) return false
        if (display_name != other.display_name) return false
        if (game_id != other.game_id) return false
        if (game_name != other.game_name) return false
        if (id != other.id) return false
        if (is_live != other.is_live) return false
        if (!tags.contentEquals(other.tags)) return false
        if (thumbnail_url != other.thumbnail_url) return false
        if (title != other.title) return false
        if (started_at != other.started_at) return false

        return true
    }

    override fun hashCode(): Int {
        var result = broadcaster_language.hashCode()
        result = 31 * result + broadcaster_login.hashCode()
        result = 31 * result + display_name.hashCode()
        result = 31 * result + game_id.hashCode()
        result = 31 * result + game_name.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + is_live.hashCode()
        result = 31 * result + tags.contentHashCode()
        result = 31 * result + thumbnail_url.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + started_at.hashCode()
        return result
    }
}