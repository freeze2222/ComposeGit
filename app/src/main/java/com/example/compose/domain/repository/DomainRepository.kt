package com.example.compose.domain.repository

import com.example.compose.domain.model.api_model.Category
import com.example.compose.domain.model.api_model.Stream
import com.example.compose.domain.model.api_model.Video

interface DomainRepository {
   suspend fun updateStreams(): MutableList<Stream>
   suspend fun updateVideos(): MutableList<Video>
   suspend fun updateCategories(search:String): MutableList<Category>
   suspend fun getPopularStreams():MutableList<Stream>
   suspend fun getM3U8Link(id: String, mediaType: String): String
}