package com.desafio_android_gustavo_rocha.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.desafio_android_gustavo_rocha.models.Character
import com.desafio_android_gustavo_rocha.repository.PersonagemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonagemViewModel(private val personagemRepository: PersonagemRepository) : ViewModel() {

    private val _characterData = MutableLiveData<List<Character>>()
    val characterData: LiveData<List<Character>> = _characterData

    fun buscar() = CoroutineScope(Dispatchers.Main).launch {
        try {
            _characterData.value = personagemRepository.buscarPersonagem()
        } catch (e: Exception) {
            Log.e("PersonagemViewModel", e.toString())
        }
    }
}