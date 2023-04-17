package com.example.compose.di

import com.example.compose.data.TwitchApi
import com.example.compose.domain.model.data.APIServerAddress
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    @Singleton
    fun provideRetrofit(): TwitchApi {
        return Retrofit.Builder()
            .baseUrl("https://api.twitch.tv")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TwitchApi::class.java)
    }

    @Provides
    @Singleton
    fun provideIPAPI(): TwitchApi {
        return Retrofit.Builder()
            .baseUrl(APIServerAddress)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TwitchApi::class.java)
    }

    @Provides
    @Singleton
    fun provideID(): TwitchApi{
        return Retrofit.Builder()
            .baseUrl("https://id.twitch.tv")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TwitchApi::class.java)
    }

}
