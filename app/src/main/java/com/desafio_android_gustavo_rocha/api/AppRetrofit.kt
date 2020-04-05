package com.desafio_android_gustavo_rocha.api

import com.desafio_android_gustavo_rocha.api.service.MarvelApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://gateway.marvel.com"

class AppRetrofit {

    private val client by lazy {
        val interceptador = okhttp3.logging.HttpLoggingInterceptor()
        interceptador.level = okhttp3.logging.HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(interceptador)
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val marvelService: MarvelApi by lazy {
        retrofit.create(MarvelApi::class.java)
    }
}