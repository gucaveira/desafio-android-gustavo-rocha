package com.desafio_android_gustavo_rocha.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.desafio_android_gustavo_rocha.api.webclient.WebClient
import com.desafio_android_gustavo_rocha.models.Comic

class ComicRepository(private val webClient: WebClient = WebClient()) {

    fun getComicsByCharacterId(id: Int): LiveData<List<Comic>> {
        val mutableLiveData = MutableLiveData<List<Comic>>()
        webClient.getComicsByCharacterId(id = id,
            quandoSucesso = {
                val results = it?.data?.results
                mutableLiveData.value = results
            },
            quandoFalha = {

            })
        return mutableLiveData
    }
}