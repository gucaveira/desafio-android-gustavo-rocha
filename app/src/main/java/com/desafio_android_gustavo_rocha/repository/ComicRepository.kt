package com.desafio_android_gustavo_rocha.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.desafio_android_gustavo_rocha.api.webclient.WebClient
import com.desafio_android_gustavo_rocha.models.Comics

class ComicRepository(private val webClient: WebClient = WebClient()) {

    fun buscarComicById(id: Int?): LiveData<List<Comics>> {
        val mutableLiveData = MutableLiveData<List<Comics>>()
        webClient.buscarComicsPorPersonagem(id = id,
            quandoSucesso = {
                val results = it?.data?.results
                mutableLiveData.value = results
            },
            quandoFalha = {

            })
        return mutableLiveData
    }
}