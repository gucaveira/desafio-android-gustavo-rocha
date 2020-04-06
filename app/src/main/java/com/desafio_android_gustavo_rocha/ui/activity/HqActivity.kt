package com.desafio_android_gustavo_rocha.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.desafio_android_gustavo_rocha.R
import com.desafio_android_gustavo_rocha.models.Character
import com.desafio_android_gustavo_rocha.models.Comics
import com.desafio_android_gustavo_rocha.repository.ComicRepository
import com.desafio_android_gustavo_rocha.ui.viewmodel.ComicViewModel
import com.desafio_android_gustavo_rocha.ui.viewmodel.factory.ComicsViewModelFactory
import com.desafio_android_gustavo_rocha.utils.Utils.KEY_CHARACTER
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_hq.*

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
        val characterId = intent.extras?.getParcelable<Character>(KEY_CHARACTER)
        if (characterId != null) {
            getComicsByCharacterId(characterId.id)
        }
    }

    fun getComicsByCharacterId(personagemId: Int) {
        viewModel.getComicsByCharacterId(personagemId).observe(this, Observer { comics ->
            comics?.let {
                instantiateFields(it)
            }
        })
    }

    private fun instantiateFields(comics: List<Comics>) {
        val comic = comics[0]

        hq_tv_titulo.text = comic.title

        if (comic.description == null || comic.description.isEmpty()) {
            hq_tv_descricao.text = "without description"
        }

        hq_tv_descricao.text = comic.description

        Picasso.get().load(comic.thumbnail?.path + "." + comic.thumbnail?.extension)
            .into(hq_img_personagem)

        val price = comic.prices?.get(0)?.price

        hq_tv_preco.text = "$ " + price.toString()
    }
}