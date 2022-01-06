package com.desafio_android_gustavo_rocha.repository

import com.desafio_android_gustavo_rocha.api.webclient.WebClient

class ComicRepository(private val webClient: WebClient) {
    suspend fun buscarPersonagemPorId(id: Int) = webClient.getComicsByCharacterId(id)
}