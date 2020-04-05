package com.desafio_android_gustavo_rocha.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.desafio_android_gustavo_rocha.api.webclient.PersonagemWebClient
import com.desafio_android_gustavo_rocha.models.Character

class CharactersRepository(
    private val webClient: PersonagemWebClient = PersonagemWebClient()
) {

    fun buscarPersonagem(): LiveData<List<Character>> {
        val mutableLiveData = MutableLiveData<List<Character>>()
        webClient.buscaPersonagem(
            quandoSucesso = {
                val list: MutableList<Character>? = it?.data?.results
                mutableLiveData.value = list
            }, quandoFalha = {}
        )
        return mutableLiveData
    }
}