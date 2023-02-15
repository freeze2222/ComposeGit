package com.example.compose.retrofit

import com.example.compose.model.api_model.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitServices {
    @GET("/helix/streams") //api.twitch.tv
    fun getStreamList(
        @Header("Authorization") auth: String,
        @Header("Client-Id") id: String = client_id
    ): Call<Any>

    @POST("/oauth2/token") //id.twitch.tv
    fun getToken(
        @Query("client_id") id: String = client_id,
        @Query("client_secret") secret: String = client_secret,
        @Query("grant_type") type: String = grant_type
    ): Call<Token>
}