package com.example.compose.model.data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.compose.model.api_model.*
import com.example.compose.retrofit.RetrofitClient
import com.google.firebase.auth.FirebaseUser
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var currentVideo: Video = Video()
    lateinit var user: FirebaseUser
    var videoLink: String = ""
    lateinit var navController: NavHostController
    lateinit var accessToken: String
    lateinit var categoriesList: MutableList<Category>
    lateinit var videoScope: Job
    var videoList = mutableListOf<Video>()

    private var tokenScope = viewModelScope.launch(Dispatchers.IO) {
        val raw =
            RetrofitClient.getClient("https://id.twitch.tv").getToken().execute()
        accessToken = "Bearer ${raw.body()!!.access_token}"
        Log.e("Debug", "$accessToken + clientId:$client_id")
    }
    private var query = mutableListOf<String>()

    init {
        Log.e("Debug", "Init")
    }

    fun updateAll(query: String): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            tokenScope.join()
            updateCategories(query).join()
            updateVideos()
            getNews("Minecraft")
        }
    }

    private fun updateCategories(search: String): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            query.clear()
            val raw =
                RetrofitClient.getClient("https://api.twitch.tv")
                    .getCategoriesList(auth = accessToken, query = search)
                    .execute()
            val gson = Gson()
            val json = gson.toJson(raw.body())
            Log.e("JSON", json)
            categoriesList = gson.fromJson(json, CategoriesList::class.java).data
            for (category in categoriesList) {
                query.add(category.id)
                Log.e("DEBUG", category.id)
            }


        }
    }

    private fun updateVideos() {
        val raw =
            RetrofitClient.getClient("https://api.twitch.tv")
                .getVideos(
                    accessToken,
                    game_id1 = query[0]
                )
                .execute()
        val gson = Gson()
        val json = gson.toJson(raw.body())
        videoList = gson.fromJson(json, VideoList::class.java).data
        videoList.forEach {
            it.thumbnail_url = it.thumbnail_url.replace("%{width}x%{height}", "1920x1080")
        }
    }

    fun getM3U8Link(id: String) {
        videoScope = viewModelScope.launch(Dispatchers.IO) {
            val raw =
                RetrofitClient.getClient(APIServerAddress)
                    .getM3U8(id)
                    .execute()
            videoLink = raw.body().toString()
        }
        videoScope.start()
    }

    fun getNews(query: String) {
        videoScope = viewModelScope.launch(Dispatchers.IO) {/*
                val raw =
                    RetrofitClient.getClient("https://newsapi.org/v2/everything/")
                        .getNews()
                        .execute()
                Log.e("Debug", raw.code().toString())

                */
        }
        videoScope.start()
    }
}
