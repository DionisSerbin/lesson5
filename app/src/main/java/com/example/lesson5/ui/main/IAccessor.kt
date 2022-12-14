package com.example.lesson5.ui.main

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface IAccessor {
    @GET("gifs/trending")
//    @Headers("X-User_agent: meow")
    suspend fun getGiphy(@Query("api_key") apiKey: String, @Query("limit") limit: Int, @Query("rating") rating: String,): Data

    companion object {
        fun create(): IAccessor {

            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder().apply {
                //addInterceptor() // Интерспеторы для авторизации
                addNetworkInterceptor(loggingInterceptor)
            }.build()

            val restrofit = Retrofit.Builder().apply {
                client(client)
                addConverterFactory(GsonConverterFactory.create())
                baseUrl("https://api.giphy.com/v1/")
            }.build()

            return restrofit.create(IAccessor::class.java)
        }
    }
}