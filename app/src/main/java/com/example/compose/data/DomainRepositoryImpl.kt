package com.example.compose.data

import com.example.compose.domain.model.api_model.Stream
import com.example.compose.domain.model.api_model.StreamList
import com.example.compose.domain.repository.DomainRepository
import com.example.compose.domain.repository.RetrofitClient
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DomainRepositoryImpl : DomainRepository {
    companion object{
        lateinit var accessToken:String
    }
    override suspend fun updateStreams(): MutableList<Stream> {
        lateinit var streamsList:MutableList<Stream>
        return withContext(Dispatchers.IO) {
            val raw =
                RetrofitClient.getClient("https://api.twitch.tv")
                    .getStreams(
                        accessToken,
                        game_id1 = query[0]
                    )
                    .execute()
            val gson = Gson()
            val json = gson.toJson(raw.body())
            streamsList = gson.fromJson(json, StreamList::class.java).data
            streamsList.forEach {
                it.view_count = it.viewer_count
                it.thumbnail_url = it.thumbnail_url.replace("{width}x{height}", "1920x1080")
                it.mediaType = "Stream"
            }
            return@withContext streamsList
        }
    }
}