package com.desafio_android_gustavo_rocha.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.desafio_android_gustavo_rocha.api.webclient.WebClient
import com.desafio_android_gustavo_rocha.models.Character

class PersonagemRepository(
    private val webClient: WebClient = WebClient()
) {

    fun buscarPersonagem(): LiveData<List<Character>> {
        val mutableLiveData = MutableLiveData<List<Character>>()
        webClient.getCharacters(
            quandoSucesso = {
                val list: MutableList<Character>? = it?.data?.results
                mutableLiveData.value = list
            }, quandoFalha = {}
        )
        return mutableLiveData
    }
}