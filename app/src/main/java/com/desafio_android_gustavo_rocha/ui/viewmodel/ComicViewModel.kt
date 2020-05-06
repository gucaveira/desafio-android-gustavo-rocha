package com.desafio_android_gustavo_rocha.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.desafio_android_gustavo_rocha.models.Comic
import com.desafio_android_gustavo_rocha.repository.ComicRepository

class ComicViewModel(private val comicRepository: ComicRepository) : ViewModel() {

    fun getComicsByCharacterId(id: Int): LiveData<List<Comic>> {
        return comicRepository.getComicsByCharacterId(id)
    }
}