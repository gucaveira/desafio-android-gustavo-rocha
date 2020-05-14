package com.desafio_android_gustavo_rocha.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.desafio_android_gustavo_rocha.models.Character
import com.desafio_android_gustavo_rocha.repository.PersonagemRepository

class PersonagemViewModel(private val personagemRepository: PersonagemRepository) : ViewModel() {

    fun buscar(): LiveData<List<Character>> {
        return personagemRepository.buscarPersonagem()
    }
}