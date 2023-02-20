package com.example.compose.retrofit

import com.example.compose.model.api_model.Token
import com.example.compose.model.api_model.client_id
import com.example.compose.model.api_model.client_secret
import com.example.compose.model.api_model.grant_type
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query
import kotlin.coroutines.CoroutineContext

interface RetrofitServices {
    @GET("/helix/streams") //api.twitch.tv
    fun getStreamList(
        @Header("Authorization") auth: String,
        @Header("Client-Id") id: String = client_id
    ): Call<Any>

    @GET("/tools/streamapi.py")
    fun getStream(
        @Query("url") user_id: String
    ): Call<Any>

    @POST("/oauth2/token") //id.twitch.tv
    fun getToken(
        @Query("client_id") id: String = client_id,
        @Query("client_secret") secret: String = client_secret,
        @Query("grant_type") type: String = grant_type
    ): Call<Token>
}

fun search(currentStreamId: String,context: CoroutineContext) {
    CoroutineScope(context).launch(Dispatchers.IO) {
        val rawStream =
            RetrofitClient
                .getClient("https://pwn.sh")
                .getStream("https://twitch.tv/$currentStreamId")
                .execute()
    }

}