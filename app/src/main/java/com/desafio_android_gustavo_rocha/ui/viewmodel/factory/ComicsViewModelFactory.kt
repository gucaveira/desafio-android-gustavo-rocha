package com.desafio_android_gustavo_rocha.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.desafio_android_gustavo_rocha.repository.ComicRepository
import com.desafio_android_gustavo_rocha.ui.viewmodel.ComicViewModel

class ComicsViewModelFactory(private val repository: ComicRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ComicViewModel(repository) as T
    }
}