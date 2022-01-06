package com.desafio_android_gustavo_rocha.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.desafio_android_gustavo_rocha.models.Comic
import com.desafio_android_gustavo_rocha.repository.ComicRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ComicViewModel(private val comicRepository: ComicRepository) : ViewModel() {

    private val _characterComicsData = MutableLiveData<List<Comic>>()
    val characterComicsData: LiveData<List<Comic>> = _characterComicsData

    fun buscarPersonagemPorId(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                _characterComicsData.value = comicRepository.buscarPersonagemPorId(id)
            } catch (e: Exception) {
                Log.e("ComicViewModel", e.toString())
            }
        }
    }
}