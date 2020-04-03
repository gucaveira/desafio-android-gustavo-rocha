package com.desafio_android_gustavo_rocha.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.desafio_android_gustavo_rocha.R
import com.desafio_android_gustavo_rocha.models.Personagem
import com.desafio_android_gustavo_rocha.ui.recyclerview.adapter.PersonagemAdapter
import com.desafio_android_gustavo_rocha.ui.viewmodel.PersonagemViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class ListaPersonagemFragment : Fragment() {

    private val adapter by lazy {
        context?.let {
            PersonagemAdapter(context = it)
        } ?: throw IllegalArgumentException("Contexto inválido")
    }
    var personagemSelecionado: (personagem: Personagem) -> Unit = {}
    private val viewModel: PersonagemViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buscarPersonagem()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraRecyclerView()
    }

    private fun configuraRecyclerView() {
        val divisor = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        recyclerPersonagem.addItemDecoration(divisor)
        recyclerPersonagem.adapter = adapter
        configuraAdapter()
    }

    private fun configuraAdapter() {
        adapter.quandoItemClicado = personagemSelecionado
    }

    private fun buscarPersonagem() {
        viewModel.buscarPersonagem().observe(this, Observer { resources ->
            resources.dado?.let {
                adapter.atualiza(it)
                resources.erro?.let { "Errro" }
            }
        })
    }
}
