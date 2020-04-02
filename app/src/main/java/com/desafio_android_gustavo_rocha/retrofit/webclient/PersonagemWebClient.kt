package com.desafio_android_gustavo_rocha.retrofit.webclient

import com.desafio_android_gustavo_rocha.BuildConfig
import com.desafio_android_gustavo_rocha.models.Comics
import com.desafio_android_gustavo_rocha.models.Personagem
import com.desafio_android_gustavo_rocha.retrofit.AppRetrofit
import com.desafio_android_gustavo_rocha.retrofit.service.MarvelApi
import com.desafio_android_gustavo_rocha.utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

private const val REQUISICAO_NAO_SUCEDIDA = "Requisição não sucedida"

class PersonagemWebClient(private val service: MarvelApi = AppRetrofit().marvelService) {

    private val defaultLimit = 10
    private var offset = 0
    private val timestamp = Date().time
    private val hash =
        Utils.md5(timestamp.toString() + BuildConfig.MARVEL_PRIVATE_KEY + BuildConfig.MARVEL_API_KEY)


    private fun <T> executaRequisicao(
        call: Call<T>,
        quandoSucesso: (personagens: T?) -> Unit,
        quandoFalha: (erro: String?) -> Unit
    ) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    quandoSucesso(response.body())
                } else {
                    quandoFalha(REQUISICAO_NAO_SUCEDIDA)
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                quandoFalha(t.message)
            }

        })
    }

    fun buscaPersonagem(
        quandoSucesso: (personagem: List<Personagem>?) -> Unit,
        quandoFalha: (erro: String?) -> Unit
    ) {
        executaRequisicao(
            service.getPersonagens(
                "-modified",
                timestamp.toString(),
                BuildConfig.MARVEL_API_KEY,
                hash,
                offset,
                defaultLimit
            ), quandoSucesso, quandoFalha
        )
    }

    fun buscarComicsPorPersonagem(
        id: Int,
        quandoSucesso: (comics: List<Comics>?) -> Unit,
        quandoFalha: (erro: String?) -> Unit
    ) {
        executaRequisicao(
            service.getComicsByPersonagemId(
                id.toString(),
                BuildConfig.MARVEL_API_KEY,
                hash,
                timestamp.toString(),
                "-onsaleDate"
            ), quandoSucesso, quandoFalha
        )

    }
}