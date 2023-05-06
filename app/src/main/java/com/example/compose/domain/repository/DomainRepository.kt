package com.example.compose.domain.repository

import com.example.compose.domain.model.api_model.Stream
import com.example.compose.domain.model.api_model.Video

interface DomainRepository {
   suspend fun updateStreams(): MutableList<Stream>
   suspend fun updateVideos(): MutableList<Video>
   suspend fun getPopularStreams():MutableList<Stream>
   suspend fun getM3U8Link(): String
   suspend fun getAccessToken(): String
   suspend fun updateCategories(): MutableList<String>
}