package com.desafio_android_gustavo_rocha.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.desafio_android_gustavo_rocha.R
import com.desafio_android_gustavo_rocha.models.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_lista.view.*

class PersonagemAdapter(
    private val context: Context,
    var personagemLista: MutableList<Character> = mutableListOf(),
    var quandoItemClicado: (noticia: Character) -> Unit = {}
) : RecyclerView.Adapter<PersonagemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personagemLista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personagem = personagemLista[position]
        holder.vincula(personagem)
    }

    fun atualiza(personagens: List<Character>) {
        notifyItemRangeRemoved(0, this.personagemLista.size)
        this.personagemLista.clear()
        this.personagemLista.addAll(personagens)
        notifyItemRangeInserted(0, this.personagemLista.size)
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private lateinit var personagem: Character

        init {
            itemView.setOnClickListener {
                if (::personagem.isInitialized) {
                    quandoItemClicado(personagem)
                }
            }
        }

        fun vincula(personagem: Character) {
            this.personagem = personagem
            itemView.item_tv_nome.text = personagem.name
            Picasso.get()
                .load("https://" + personagem.thumbnail.path + personagem.thumbnail.extension)
                .into(itemView.item_img_personagem)
        }
    }
}