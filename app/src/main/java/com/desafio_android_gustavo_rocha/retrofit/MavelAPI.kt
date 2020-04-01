package com.desafio_android_gustavo_rocha.retrofit

import androidx.annotation.Nullable
import androidx.lifecycle.LiveData
import com.desafio_android_gustavo_rocha.models.DetalheResponse
import com.desafio_android_gustavo_rocha.models.PersonagemResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("/v1/public/characters")
    fun getPersonagem(
        @SuppressWarnings("SameParameterValue") @Nullable @Query("orderBy") modified: String,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Nullable @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): LiveData<Response<PersonagemResponse>>

    @GET("/v1/public/characters/{id}")
    fun getDetalhePersonagem(
        @Path("id") id: String,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    )
            : LiveData<Response<PersonagemResponse>>

    @GET("/v1/public/characters/{characterId}/comics")
    fun getComicsByPersonagemId(
        @Path("characterId") personagemId: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") ts: String,
        @Query("orderBy") orderBy: String
    ): LiveData<Response<DetalheResponse>>
}