package com.desafio_android_gustavo_rocha.asynctask

import android.os.AsyncTask

class BaseAsyncTask<T>(
    private val executar: () -> T,
    private val finalizado: (resultado: T) -> Unit
) : AsyncTask<Void, Void, T>() {

    override fun doInBackground(vararg params: Void?): T = executar()

    override fun onPostExecute(result: T) {
        super.onPostExecute(result)
        finalizado(result)
    }
}