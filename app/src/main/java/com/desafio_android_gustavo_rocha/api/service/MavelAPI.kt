package com.desafio_android_gustavo_rocha.api.service

import androidx.annotation.Nullable
import com.desafio_android_gustavo_rocha.models.CharacterResponse
import com.desafio_android_gustavo_rocha.models.ComicsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("/v1/public/characters")
   suspend fun getCharacters(
        @Query("orderBy") modified: String,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Nullable @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<CharacterResponse>

    @GET("/v1/public/characters/{characterId}/comics")
    suspend fun getComicsByCharacterId(
        @Path("characterId") personagemId: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") ts: String,
        @Query("orderBy") orderBy: String,
        @Query("noVariants") ComicsVariants: Boolean
    ):  Response<ComicsResponse>
}