package com.example.compose.presentation.screen.main
/*
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.compose.data.DomainRepositoryImpl
import com.example.compose.domain.model.api_model.*
import com.example.compose.domain.model.data.APIServerAddress
import com.example.compose.di.RetrofitClient
import com.google.firebase.auth.FirebaseUser
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModelOld : ViewModel() {

    var isClicked: Boolean = false
    lateinit var popularStreamsScope: Job
    lateinit var user: FirebaseUser
    var videoLink: String = ""
    lateinit var navController: NavHostController
    lateinit var accessToken: String
    lateinit var categoriesList: MutableList<Category>
    lateinit var videoScope: Job
    var videoList = mutableListOf<Video>()
    var popularStreamList = mutableListOf<Stream>()
    var streamsList = mutableListOf<Stream>()
    private var tokenScope = viewModelScope.launch(Dispatchers.IO) {
        val raw =
            RetrofitClient.getClient("https://id.twitch.tv").getToken().execute()
        accessToken = "Bearer ${raw.body()!!.access_token}"
        DomainRepositoryImpl.accessToken = accessToken
        //Log.e("Debug", "$accessToken + clientId:$client_id")
    }
    private var query = mutableListOf<String>()

    init {
        getPopularStreams()
        Log.e("Debug", "Init")
    }

    fun updateAll(query: String): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            tokenScope.join()
            updateCategories(query).join()
            updateVideos()
            updateStreams()
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

    private fun updateStreams() {
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
    }

    fun getM3U8Link(id: String, mediaType: String) {
        videoScope = viewModelScope.launch(Dispatchers.IO) {
                val raw =
                    RetrofitClient.getClient(APIServerAddress)
                        .getM3U8(id, if (mediaType == "Video") "i" else "v")
                        .execute()
                videoLink = raw.body().toString()
        }
        videoScope.start()
    }

    private fun getPopularStreams() {
       popularStreamsScope = viewModelScope.launch(Dispatchers.IO) {
            tokenScope.join()
            val raw =
                RetrofitClient.getClient("https://api.twitch.tv")
                    .getPopularStreams(accessToken)
                    .execute()
            val gson = Gson()
            val json = gson.toJson(raw.body())
            popularStreamList = gson.fromJson(json, StreamList::class.java).data
            popularStreamList.forEach {
                it.thumbnail_url = it.thumbnail_url.replace("{width}x{height}", "1920x1080")
                it.mediaType = "Stream"
            }
        }
    }
}
 */