package com.desafio_android_gustavo_rocha.di.modules

import com.desafio_android_gustavo_rocha.api.webclient.PersonagemWebClient
import com.desafio_android_gustavo_rocha.repository.CharactersRepository
import com.desafio_android_gustavo_rocha.ui.viewmodel.PersonagemViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModules = module {

    single<PersonagemWebClient> {
        PersonagemWebClient(get())
    }

    single<CharactersRepository> {
        CharactersRepository(get())
    }

    viewModel<PersonagemViewModel> {
        PersonagemViewModel(get())
    }

}
