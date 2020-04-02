package com.desafio_android_gustavo_rocha.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.desafio_android_gustavo_rocha.R
import com.desafio_android_gustavo_rocha.models.Personagem
import kotlinx.android.synthetic.main.item_lista.view.*


class PersonagemAdapter(
    private val context: Context,
    private val personagemLista: MutableList<Personagem> = mutableListOf(),
    var quandoItemClicado: (noticia: Personagem) -> Unit = {}
) : RecyclerView.Adapter<PersonagemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personagemLista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personagem = personagemLista[position]
        holder.vincula(personagem)
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private lateinit var personagem: Personagem

        init {
            itemView.setOnClickListener {
                if (::personagem.isInitialized) {
                    quandoItemClicado(personagem)
                }
            }
        }

        fun vincula(personagem: Personagem) {
            this.personagem = personagem
            itemView.item_tv_nome.text = personagem.name
        }
    }
}