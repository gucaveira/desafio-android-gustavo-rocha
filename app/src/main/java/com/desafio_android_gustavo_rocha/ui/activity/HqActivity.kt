package com.desafio_android_gustavo_rocha.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.desafio_android_gustavo_rocha.R
import com.desafio_android_gustavo_rocha.models.Character
import com.desafio_android_gustavo_rocha.repository.ComicRepository
import com.desafio_android_gustavo_rocha.ui.viewmodel.ComicViewModel
import com.desafio_android_gustavo_rocha.ui.viewmodel.factory.ComicsViewModelFactory
import com.desafio_android_gustavo_rocha.utils.Utils.CHAVE_PERSONAGEM
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detalhe_personagem.*

class HqActivity : AppCompatActivity() {

    private val viewModel by lazy {
        val repository = ComicRepository()
        val factory = ComicsViewModelFactory(repository)
        val provedor = ViewModelProviders.of(this, factory)
        provedor.get(ComicViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_hq)
        val parcelable = intent.extras?.getParcelable<Character>(CHAVE_PERSONAGEM)
        buscarPorId(parcelable)
    }

    fun buscarPorId(personagemId: Character?) {
        personagemId.comics.prices.filter { personagemId.id }
        viewModel.buscarById(personagemId).observe(this, Observer {
            val comics = it[0]
            detalhe_btn_preco.text =
                comics.prices?.get(comics.prices.get(0).price.toInt())?.price.toString()
            detalhe_tv_nome.text = comics.fullName
            detalhe_tv_descricao.text = comics.description
            Picasso.get().load(comics.thumbnail?.path + "." + comics.thumbnail?.extension)
                .into(detalhe_img_personagem)
        })
    }
}
