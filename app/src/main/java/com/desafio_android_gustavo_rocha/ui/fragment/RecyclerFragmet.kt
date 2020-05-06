package com.desafio_android_gustavo_rocha.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.desafio_android_gustavo_rocha.R
import com.desafio_android_gustavo_rocha.repository.CharactersRepository
import com.desafio_android_gustavo_rocha.ui.recyclerview.adapter.PersonagemAdapter
import com.desafio_android_gustavo_rocha.ui.viewmodel.PersonagemViewModel
import com.desafio_android_gustavo_rocha.ui.viewmodel.factory.PersonagemViewModelFactory
import kotlinx.android.synthetic.main.recycler.*
import org.koin.android.ext.android.inject

class RecyclerFragmet : Fragment() {

    private val adapter: PersonagemAdapter by inject()

    private val viewModel by lazy {
        val repository = CharactersRepository()
        val factory = PersonagemViewModelFactory(repository)
        val provedor = ViewModelProviders.of(this, factory)
        provedor.get(PersonagemViewModel::class.java)
    }

    private val controller by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buscarPersonagem()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraRecyclerView()
    }

    private fun configuraRecyclerView() {
        val divisor = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        recyclerPersonagem.addItemDecoration(divisor)
        adapter.quandoItemClicado = {
            val directions = RecyclerFragmetDirections.actionListaPersonagemToDetalhe(it)
            controller.navigate(directions)
        }
        recyclerPersonagem.adapter = adapter
    }


    private fun buscarPersonagem() {
        viewModel.buscar().observe(this, Observer {
            it?.let { persongens ->
                adapter.atualiza(persongens)
            }
        })
    }
}