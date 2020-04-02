package com.desafio_android_gustavo_rocha.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.desafio_android_gustavo_rocha.models.Personagem
import com.desafio_android_gustavo_rocha.retrofit.webclient.PersonagemWebClient

class PersonagemRepository(private val webClient: PersonagemWebClient) {

    private val mediatorLiveData = MediatorLiveData<Resource<List<Personagem>?>>()


    //fun buscar(): LiveData<Resource<List<Personagem>?>> {
    //}
}