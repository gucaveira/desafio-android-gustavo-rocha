package com.desafio_android_gustavo_rocha.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.desafio_android_gustavo_rocha.R
import com.desafio_android_gustavo_rocha.ui.activity.extensions.transacaofragment
import com.desafio_android_gustavo_rocha.ui.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        transacaofragment {
            this.add(R.id.fragment_personagem, MainFragment())
        }
    }
}
