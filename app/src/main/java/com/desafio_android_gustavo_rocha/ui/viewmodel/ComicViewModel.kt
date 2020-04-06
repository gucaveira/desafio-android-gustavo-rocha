package com.desafio_android_gustavo_rocha.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.desafio_android_gustavo_rocha.models.Comics
import com.desafio_android_gustavo_rocha.repository.ComicRepository

class ComicViewModel(private val comicRepository: ComicRepository) : ViewModel() {

    fun buscarById(id: Int?): LiveData<List<Comics>> {
        return comicRepository.buscarComicById(id)
    }
}