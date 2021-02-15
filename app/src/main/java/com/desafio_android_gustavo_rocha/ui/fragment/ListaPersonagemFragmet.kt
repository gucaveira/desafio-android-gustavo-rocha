package com.desafio_android_gustavo_rocha.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.desafio_android_gustavo_rocha.R
import com.desafio_android_gustavo_rocha.databinding.ListaPersonagemBinding
import com.desafio_android_gustavo_rocha.ui.recyclerview.adapter.PersonagemAdapter
import com.desafio_android_gustavo_rocha.ui.viewmodel.PersonagemViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ListaPersonagemFragmet : Fragment(R.layout.lista_personagem) {

    private val adapter: PersonagemAdapter by inject()
    private lateinit var bind: ListaPersonagemBinding

    private val viewModel by viewModel<PersonagemViewModel>()

    private val controller by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = ListaPersonagemBinding.bind(view)
        buscarPersonagem()

        configuraRecyclerView()
    }

    private fun configuraRecyclerView() {
        val divisor = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        bind.recyclerPersonagem.addItemDecoration(divisor)
        bind.recyclerPersonagem.adapter = adapter
        adapter.quandoItemClicado = {
            val directions =
                ListaPersonagemFragmetDirections.actionListaPersonagemToDetalhePersonagem(it)
            controller.navigate(directions)
        }
    }


    private fun buscarPersonagem() {
        viewModel.buscar().observe(viewLifecycleOwner, Observer {
            it?.let { persongens ->
                adapter.atualiza(persongens)
            }
        })
    }
}