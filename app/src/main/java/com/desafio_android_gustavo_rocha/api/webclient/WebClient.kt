package com.desafio_android_gustavo_rocha.api.webclient

import com.desafio_android_gustavo_rocha.BuildConfig
import com.desafio_android_gustavo_rocha.api.service.MarvelApi
import com.desafio_android_gustavo_rocha.models.Character
import com.desafio_android_gustavo_rocha.models.Comic
import com.desafio_android_gustavo_rocha.extensions.md5
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.coroutines.suspendCoroutine

class WebClient(private val service: MarvelApi) {

    private val defaultLimit = 80
    private var offset = 0
    private val timestamp = Date().time.toString()
    private val hash = md5(timestamp + BuildConfig.MARVEL_PRIVATE_KEY + BuildConfig.MARVEL_API_KEY)

    suspend fun getCharacters(): List<Character> {
        return suspendCoroutine { continuation ->
            CoroutineScope(Dispatchers.IO).launch {

                val response = service.getCharacters(
                        "-modified",
                        timestamp,
                        BuildConfig.MARVEL_API_KEY,
                        hash,
                        offset,
                        defaultLimit)

                if (response.isSuccessful) {
                    response.body()?.data?.let {
                        continuation.resumeWith(Result.success(it.results))

                    } ?: continuation.resumeWith(Result.failure(Throwable(response.errorBody().toString())))

                } else {
                    continuation.resumeWith(Result.failure(Throwable(response.errorBody().toString())))
                }
            }
        }
    }

    suspend fun getComicsByCharacterId(id: Int?): List<Comic> {
        return suspendCoroutine { continuation ->
            CoroutineScope(Dispatchers.IO).launch {
                val response =
                    service.getComicsByCharacterId(id.toString(),
                        BuildConfig.MARVEL_API_KEY,
                        hash,
                        timestamp,
                        "-modified",
                        true)

                if (response.isSuccessful) {
                    response.body()?.data?.let {
                        continuation.resumeWith(Result.success(it.results))

                    } ?: continuation.resumeWith(Result.failure(Throwable(response.errorBody().toString())))

                } else {
                    continuation.resumeWith(Result.failure(Throwable(response.errorBody().toString())))
                }
            }
        }
    }
}