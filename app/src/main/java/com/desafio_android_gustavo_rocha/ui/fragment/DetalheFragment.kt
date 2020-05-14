package com.desafio_android_gustavo_rocha.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.desafio_android_gustavo_rocha.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_personagem.*

class DetalheFragment : Fragment() {

    private val argument by navArgs<DetalheFragmentArgs>()
    private val personagem by lazy { argument.personagem }
    private val controller by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_personagem, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character = personagem

        detalhe_tv_titulo.text = character.name
        detalhe_tv_descricao.text = character.description
        Picasso.get()
            .load(character.thumbnail.path + "." + character.thumbnail.extension)
            .into(detalhe_img_personagem)

        detalhe_btn_preco.setOnClickListener {
            val directions = DetalheFragmentDirections.actionDetalhePersonagemToComigs(personagem.id)
            controller.navigate(directions)
        }
    }
}