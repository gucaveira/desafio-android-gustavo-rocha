package com.desafio_android_gustavo_rocha.di.modules

import com.desafio_android_gustavo_rocha.repository.PersonagemRepository
import com.desafio_android_gustavo_rocha.retrofit.webclient.PersonagemWebClient
import com.desafio_android_gustavo_rocha.ui.viewmodel.PersonagemViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModules = module {

    single<PersonagemWebClient> {
        PersonagemWebClient()
    }

    single<PersonagemRepository> {
        PersonagemRepository(get())
    }

    viewModel<PersonagemViewModel> {
        PersonagemViewModel(get())
    }

}
