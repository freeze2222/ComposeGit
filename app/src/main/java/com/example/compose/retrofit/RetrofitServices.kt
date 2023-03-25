package com.example.compose.retrofit

import androidx.compose.ui.text.intl.Locale
import com.example.compose.model.api_model.*
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @Deprecated("Currently hasn't got any functions")
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

    @GET("/i/{id}")
    fun getM3U8(
        @Path("id") id: String
    ): Call<Any>

    @GET("/")
    fun getNews(
        @Query("q") query: String = "tesla",
        @Query("from") from: String = "2023-02-25",
        @Query("sortBy") sortBy: String = "popularity",
        @Query("apiKey") news_secret: String = news_api
    ): Call<Any>
}