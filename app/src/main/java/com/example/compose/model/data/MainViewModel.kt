package com.example.compose.model.data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.compose.model.api_model.Stream
import com.example.compose.model.api_model.StreamList
import com.example.compose.retrofit.RetrofitClient
import com.google.firebase.auth.FirebaseUser
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel() : ViewModel() {
    lateinit var currentUser: FirebaseUser
    var currentStreamId: String = "lec"
    lateinit var navController: NavHostController
    lateinit var accessToken: String
    lateinit var streamList:MutableList<*>
    lateinit var coroutineContext: CoroutineContext
    var tokenScope: Job =
        viewModelScope.launch(Dispatchers.IO) {
             val raw =
                 RetrofitClient.getClient("https://id.twitch.tv").getToken().execute()
             accessToken = "Bearer ${raw.body()!!.access_token}"
     }
    var streamScope: Job =
        viewModelScope.launch(Dispatchers.IO) {
            tokenScope.join()
            val raw =
                RetrofitClient.getClient("https://api.twitch.tv").getStreamList(accessToken).execute()
            val gson = Gson()
            val json = gson.toJson(raw.body())
            streamList = gson.fromJson(json,StreamList::class.java).data
            streamList.forEach {
                (it as Stream).thumbnail_url = it.thumbnail_url.replace("{width}x{height}","1920x1080")
            }
            Log.e("Debug", streamList.toString())
            Log.e("Debug", accessToken)
            this@MainViewModel.coroutineContext = viewModelScope.coroutineContext
        }
}