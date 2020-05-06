package com.desafio_android_gustavo_rocha.di.modules

import com.desafio_android_gustavo_rocha.api.webclient.WebClient
import com.desafio_android_gustavo_rocha.repository.CharactersRepository
import com.desafio_android_gustavo_rocha.ui.recyclerview.adapter.PersonagemAdapter
import com.desafio_android_gustavo_rocha.ui.viewmodel.PersonagemViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModules = module {

    single<WebClient> {
        WebClient(get())
    }

    single<CharactersRepository> {
        CharactersRepository(get())
    }

    viewModel<PersonagemViewModel> {
        PersonagemViewModel(get())
    }
}

val uiModule = module {
    factory<PersonagemAdapter> { PersonagemAdapter(get()) }
}