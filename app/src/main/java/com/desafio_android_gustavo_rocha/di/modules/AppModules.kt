package com.desafio_android_gustavo_rocha.di.modules

import com.desafio_android_gustavo_rocha.api.webclient.WebClient
import com.desafio_android_gustavo_rocha.repository.ComicRepository
import com.desafio_android_gustavo_rocha.repository.PersonagemRepository
import com.desafio_android_gustavo_rocha.ui.fragment.ComicFragment
import com.desafio_android_gustavo_rocha.ui.fragment.DetalhePersonagemFragment
import com.desafio_android_gustavo_rocha.ui.fragment.ListaPersonagemFragmet
import com.desafio_android_gustavo_rocha.ui.recyclerview.adapter.PersonagemAdapter
import com.desafio_android_gustavo_rocha.ui.viewmodel.ComicViewModel
import com.desafio_android_gustavo_rocha.ui.viewmodel.PersonagemViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val daoModule = module {
    single<WebClient> { WebClient(get()) }
    single<PersonagemRepository> { PersonagemRepository(get()) }
    single<ComicRepository> { ComicRepository() }
}

val viewModelModule = module {
    viewModel<PersonagemViewModel> { PersonagemViewModel(get()) }
    viewModel<ComicViewModel> { ComicViewModel(get()) }
}

val uiModule = module {
    factory<ComicFragment> { ComicFragment() }
    factory<DetalhePersonagemFragment> { DetalhePersonagemFragment() }
    factory<ListaPersonagemFragmet> { ListaPersonagemFragmet() }
    factory<PersonagemAdapter> { PersonagemAdapter(get()) }
}