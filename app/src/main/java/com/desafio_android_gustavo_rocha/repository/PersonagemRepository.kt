package com.desafio_android_gustavo_rocha.repository

import com.desafio_android_gustavo_rocha.api.webclient.WebClient

class PersonagemRepository(private val webClient: WebClient) {

    suspend fun buscarPersonagem() = webClient.getCharacters()
}