package com.example.compose.domain.repository

import androidx.compose.ui.text.intl.Locale
import com.example.compose.domain.model.api_model.Token
import com.example.compose.domain.model.api_model.client_id
import com.example.compose.domain.model.api_model.client_secret
import com.example.compose.domain.model.api_model.grant_type
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {

    @POST("/oauth2/token") //id.twitch.tv
    fun getToken(
        @Query("client_id") id: String = client_id,
        @Query("client_secret") secret: String = client_secret,
        @Query("grant_type") type: String = grant_type
    ): Call<Token>

    @GET("/helix/search/categories")
    fun getCategoriesList(
        @Header("Authorization") auth: String,
        @Header("Client-Id") id: String = client_id,
        @Query("query") query: String,
        @Query("first") first: Int = 1
    ): Call<Any>

    @GET("/helix/videos")
    fun getVideos(
        @Header("Authorization") auth: String,
        @Header("Client-Id") id: String = client_id,
        @Query("first") first: Int = 100,
        @Query("language") language: String = Locale.current.language,
        @Query("sort") sort: String = "trending",
        @Query("game_id") game_id1: String
    ): Call<Any>

    @GET("/helix/streams") //api.twitch.tv
    fun getStreams(
        @Header("Authorization") auth: String,
        @Header("Client-Id") id: String = client_id,
        @Query("first") first: Int = 100,
        @Query("language") language: String = Locale.current.language,
        @Query("sort") sort: String = "trending",
        @Query("game_id") game_id1: String
    ): Call<Any>

    @GET("/{tag}/{id}")
    fun getM3U8(
        @Path("id") id: String,
        @Path("tag") tag: String
    ): Call<Any>

    @GET("/helix/streams")
    fun getPopularStreams(
        @Header("Authorization") auth: String,
        @Header("Client-Id") id: String = client_id,
        @Query("first") first: Int = 10,
        @Query("language") language: String = Locale.current.language
    ): Call<Any>
}