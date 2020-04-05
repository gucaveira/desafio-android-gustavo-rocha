package com.desafio_android_gustavo_rocha.ui.activity

import android.app.Activity
import android.os.Bundle
import com.desafio_android_gustavo_rocha.R
import com.desafio_android_gustavo_rocha.models.Character
import com.desafio_android_gustavo_rocha.utils.Utils.CHAVE_PERSONAGEM
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detalhe_personagem.*

class DetalheActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detalhe_personagem)

        val character = intent.extras?.getParcelable<Character>(CHAVE_PERSONAGEM)

        detalhe_tv_nome.text = character?.name
        detalhe_tv_descricao.text = character?.description
        Picasso.get()
            .load(character?.thumbnail?.path + "." + character?.thumbnail?.extension)
            .into(detalhe_img_personagem)
    }
}