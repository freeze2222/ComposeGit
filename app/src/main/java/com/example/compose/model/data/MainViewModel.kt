package com.example.compose.model.data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.compose.model.api_model.CategoriesList
import com.example.compose.model.api_model.Category
import com.example.compose.model.api_model.Video
import com.example.compose.model.api_model.VideoList
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
        //Log.e("Debug", "$accessToken + clientId:$client_id")
    }
    private var query = mutableListOf<String>()

    init {
        Log.e("Debug", "Init")
        updateAll("Minecraft")
    }

    fun updateAll(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            tokenScope.join()
            updateCategories(query)
            updateVideos()
        }
    }

    private fun updateCategories(search: String) {
        val raw =
            RetrofitClient.getClient("https://api.twitch.tv")
                .getCategoriesList(auth = accessToken, query = search)
                .execute()
        val gson = Gson()
        val json = gson.toJson(raw.body())
        categoriesList = gson.fromJson(json, CategoriesList::class.java).data
        var i = 0
        while (i <= 2) {
            query.add(categoriesList[i].id)
            i++
        }
    }

    private fun updateVideos() {
        val raw =
            RetrofitClient.getClient("https://api.twitch.tv")
                .getVideos(
                    accessToken,
                    game_id1 = query[0],
                    game_id2 = query[1],
                    game_id3 = query[2]
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
}
