package com.desafio_android_gustavo_rocha.di.modules

import com.desafio_android_gustavo_rocha.api.service.MarvelApi
import com.desafio_android_gustavo_rocha.api.webclient.WebClient
import com.desafio_android_gustavo_rocha.repository.ComicRepository
import com.desafio_android_gustavo_rocha.repository.PersonagemRepository
import com.desafio_android_gustavo_rocha.ui.fragment.ComicFragment
import com.desafio_android_gustavo_rocha.ui.fragment.DetalhePersonagemFragment
import com.desafio_android_gustavo_rocha.ui.fragment.ListaPersonagemFragmet
import com.desafio_android_gustavo_rocha.ui.recyclerview.adapter.PersonagemAdapter
import com.desafio_android_gustavo_rocha.ui.viewmodel.ComicViewModel
import com.desafio_android_gustavo_rocha.ui.viewmodel.PersonagemViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://gateway.marvel.com"

val retrofitModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<MarvelApi> { get<Retrofit>().create(MarvelApi::class.java) }
    single {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }
}

val daoModule = module {
    single { WebClient(get()) }
    single { PersonagemRepository(get()) }
    single { ComicRepository(get()) }
}

val viewModelModule = module {
    viewModel { PersonagemViewModel(get()) }
    viewModel { ComicViewModel(get()) }
}

val uiModule = module {
    factory { ComicFragment() }
    factory { DetalhePersonagemFragment() }
    factory { ListaPersonagemFragmet() }
    factory { PersonagemAdapter() }
}