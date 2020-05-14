package com.desafio_android_gustavo_rocha.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.desafio_android_gustavo_rocha.repository.PersonagemRepository
import com.desafio_android_gustavo_rocha.ui.viewmodel.PersonagemViewModel

class PersonagemViewModelFactory(private val repository: PersonagemRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PersonagemViewModel(repository) as T
    }
}
