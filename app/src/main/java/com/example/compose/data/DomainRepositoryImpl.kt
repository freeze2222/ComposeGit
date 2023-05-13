package com.example.compose.data

import android.util.Log
import androidx.navigation.NavHostController
import com.example.compose.di.RetrofitModule
import com.example.compose.domain.model.api_model.*
import com.example.compose.domain.repository.DomainRepository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DomainRepositoryImpl @Inject constructor() : DomainRepository {
    companion object {
        var isReferenced: Boolean = false
        lateinit var navController: NavHostController
        lateinit var accessToken: String
        var categories: MutableList<String> = emptyList<String>().toMutableList()
        lateinit var id: String
        lateinit var mediaType:String
        var query: String = "Minecraft"
        var page = "Streams"
    }

    override suspend fun updateCategories(): MutableList<String> {
        return withContext(Dispatchers.IO) {
            categories.clear()
            Log.e("Query", query)
            val raw =
                RetrofitModule.provideRetrofit()
                    .getCategoriesList(auth = accessToken, query = query)
                    .execute()
            val gson = Gson()
            val json = gson.toJson(raw.body())
            Log.e("JSON", json)
            val categoriesList = gson.fromJson(json, CategoriesList::class.java).data
            for (category in categoriesList) {
                categories.add(category.id)
            }
            return@withContext categories
        }
    }

    override suspend fun updateStreams(): MutableList<Stream> {
        Log.e("DEBUG","UpdateStreamsStart")
        lateinit var streamsList: MutableList<Stream>
        return withContext(Dispatchers.IO) {
            val raw =
                RetrofitModule.provideRetrofit()
                    .getStreams(
                        accessToken,
                        game_id1 = categories[0]
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
            Log.e("DEBUG","UpdateStreamsEnd, returned:${streamsList}")
            return@withContext streamsList
        }
    }

    override suspend fun updateVideos(): MutableList<Video> {
        return withContext(Dispatchers.IO){
            Log.e("Categories", categories[0])
            val raw =
                RetrofitModule.provideRetrofit()
                    .getVideos(
                        accessToken,
                        game_id1 = categories[0]
                    )
                    .execute()
            val gson = Gson()
            val json = gson.toJson(raw.body())
            val videoList = gson.fromJson(json, VideoList::class.java).data
            Log.e("VideoCode",raw.code().toString())
            videoList.forEach {
                it.thumbnail_url = it.thumbnail_url.replace("%{width}x%{height}", "1920x1080")
            }
            Log.e("VideoDeb",videoList.toString())
            return@withContext videoList
        }
    }

    override suspend fun getM3U8Link(): String {
        return withContext(Dispatchers.IO) {
            val raw =
                RetrofitModule.provideIPAPI()
                    .getM3U8(id, if (mediaType == "Video") "i" else "v")
                    .execute()
            Log.e("DebugM3U8",raw.body().toString())
            return@withContext raw.body().toString()
        }
    }

    override suspend fun getPopularStreams(): MutableList<Stream> {
        return withContext(Dispatchers.IO) {
            val raw =
                RetrofitModule.provideRetrofit()
                    .getPopularStreams(accessToken)
                    .execute()
            val gson = Gson()
            val json = gson.toJson(raw.body())
            val popularStreamList = gson.fromJson(json, StreamList::class.java).data
            popularStreamList.forEach {
                it.thumbnail_url = it.thumbnail_url.replace("{width}x{height}", "1920x1080")
                it.mediaType = "Stream"
            }
            return@withContext popularStreamList
        }

    }
    override suspend fun getAccessToken(): String{
        return withContext(Dispatchers.IO) {
            val raw = RetrofitModule.provideID().getToken().execute()
            accessToken = "Bearer ${raw.body()!!.access_token}"
            Log.e("DEBUG","Token:$accessToken, ClientId:$client_id")
            return@withContext accessToken
        }
    }
}