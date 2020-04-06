package com.desafio_android_gustavo_rocha.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.desafio_android_gustavo_rocha.R
import com.desafio_android_gustavo_rocha.models.Character
import com.desafio_android_gustavo_rocha.repository.CharactersRepository
import com.desafio_android_gustavo_rocha.ui.recyclerview.adapter.PersonagemAdapter
import com.desafio_android_gustavo_rocha.ui.viewmodel.PersonagemViewModel
import com.desafio_android_gustavo_rocha.ui.viewmodel.factory.PersonagemViewModelFactory
import com.desafio_android_gustavo_rocha.utils.Utils.KEY_CHARACTER
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter by lazy {
        PersonagemAdapter(context = this)
    }


    private val viewModel by lazy {
        val repository = CharactersRepository()
        val factory = PersonagemViewModelFactory(repository)
        val provedor = ViewModelProviders.of(this, factory)
        provedor.get(PersonagemViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buscarPersonagem()
        configuraRecyclerView()
    }

    private fun configuraRecyclerView() {
        val divisor = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
        recyclerPersonagem.addItemDecoration(divisor)
        recyclerPersonagem.adapter = adapter
        configuraAdapter()
    }

    private fun configuraAdapter() {
        adapter.quandoItemClicado = this::abreDetalhes
    }

    private fun abreDetalhes(it: Character) {
        val intent = Intent(this, DetalheActivity::class.java)
        intent.putExtra(KEY_CHARACTER, it)
        startActivity(intent)
    }

    private fun buscarPersonagem() {
        viewModel.buscar().observe(this, Observer {
            it?.let { persongens ->
                adapter.atualiza(persongens)
            }
        })
    }
}