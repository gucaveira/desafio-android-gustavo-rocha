package com.desafio_android_gustavo_rocha.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.desafio_android_gustavo_rocha.R
import com.desafio_android_gustavo_rocha.models.Comic
import com.desafio_android_gustavo_rocha.repository.ComicRepository
import com.desafio_android_gustavo_rocha.ui.viewmodel.ComicViewModel
import com.desafio_android_gustavo_rocha.ui.viewmodel.factory.ComicsViewModelFactory
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_hq.*

class HqFragment : Fragment() {

    private val viewModel by lazy {
        val repository = ComicRepository()
        val factory = ComicsViewModelFactory(repository)
        val provedor = ViewModelProviders.of(this, factory)
        provedor.get(ComicViewModel::class.java)
    }

    private val argument by navArgs<HqFragmentArgs>()
    private val idPersonagem by lazy { argument.comicId }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getComicsByCharacterId(idPersonagem)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hq, container, false)
    }

    fun getComicsByCharacterId(personagemId: Int) {
        viewModel.getComicsByCharacterId(personagemId).observe(this, Observer { comics ->
            comics?.let {
                instantiateFields(it)
            }
        })
    }

    private fun instantiateFields(comics: List<Comic>) {

        //mudar para price
        val comicMaisCara = comics.sortedBy { it.id }
        val comic = comicMaisCara[0]

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