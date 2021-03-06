package com.desafio_android_gustavo_rocha.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.desafio_android_gustavo_rocha.R
import com.desafio_android_gustavo_rocha.models.Character
import com.desafio_android_gustavo_rocha.utils.Utils.KEY_CHARACTER
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detalhe_personagem.*

class DetalheActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detalhe_personagem)

        val character = intent.extras?.getParcelable<Character>(KEY_CHARACTER)

        detalhe_tv_titulo.text = character?.name
        detalhe_tv_descricao.text = character?.description
        Picasso.get()
            .load(character?.thumbnail?.path + "." + character?.thumbnail?.extension)
            .into(detalhe_img_personagem)

        detalhe_btn_preco.setOnClickListener {
            val intent = Intent(this, HqActivity::class.java)
            intent.putExtra(KEY_CHARACTER, character)
            startActivity(intent)

        }
    }
}