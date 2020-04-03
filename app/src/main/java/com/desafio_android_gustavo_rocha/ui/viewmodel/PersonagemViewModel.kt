package com.desafio_android_gustavo_rocha.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.desafio_android_gustavo_rocha.models.Personagem
import com.desafio_android_gustavo_rocha.repository.PersonagemRepository
import com.desafio_android_gustavo_rocha.repository.Resource

class PersonagemViewModel(private val repository: PersonagemRepository) : ViewModel() {

    fun buscarPersonagem(): LiveData<Resource<List<Personagem>?>> {
        return repository.buscarPersonagem()
    }
}