package com.desafio_android_gustavo_rocha.ui.activity.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

fun AppCompatActivity.transacaofragment(executa: FragmentTransaction.() -> Unit) {
    val transaction = supportFragmentManager.beginTransaction()
    executa(transaction)
    transaction.commit()
}