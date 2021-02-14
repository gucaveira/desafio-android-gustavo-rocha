package com.desafio_android_gustavo_rocha.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.desafio_android_gustavo_rocha.R
import com.desafio_android_gustavo_rocha.databinding.FragmentDetalhePersonagemBinding
import com.squareup.picasso.Picasso

class DetalhePersonagemFragment : Fragment(R.layout.fragment_detalhe_personagem) {

    private val argument by navArgs<DetalhePersonagemFragmentArgs>()
    private val personagem by lazy { argument.personagem }
    private val controller by lazy { findNavController() }
    private lateinit var bind: FragmentDetalhePersonagemBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentDetalhePersonagemBinding.bind(view)

        bind.detalheTvTitulo.text = personagem.name
        bind.detalheTvDescricao.text = personagem.description
        inflaterImage()

        bind.detalheBtnPreco.setOnClickListener {
            val directions =
                DetalhePersonagemFragmentDirections.actionDetalhePersonagemToComic(personagem.id)
            controller.navigate(directions)
        }
    }

    private fun inflaterImage() {
        Picasso.get()
            .load(personagem.thumbnail.path + "." + personagem.thumbnail.extension)
            .into(bind.detalheImgPersonagem)
    }
}