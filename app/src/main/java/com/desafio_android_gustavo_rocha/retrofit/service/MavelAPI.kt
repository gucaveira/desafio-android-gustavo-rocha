package com.desafio_android_gustavo_rocha.retrofit.service

import androidx.annotation.Nullable
import com.desafio_android_gustavo_rocha.models.Comics
import com.desafio_android_gustavo_rocha.models.Personagem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("/v1/public/characters")
    fun getPersonagens(
        @SuppressWarnings("SameParameterValue") @Nullable
        @Query("orderBy") modified: String,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Nullable @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<List<Personagem>>

    @GET("/v1/public/characters/{characterId}/comics")
    fun getComicsByPersonagemId(
        @Path("characterId") personagemId: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") ts: String,
        @Query("orderBy") orderBy: String
    ): Call<List<Comics>>
}