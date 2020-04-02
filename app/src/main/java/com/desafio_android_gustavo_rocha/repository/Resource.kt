package com.desafio_android_gustavo_rocha.repository

data class Resource<T>(
    val dado: T?,
    val erro: Throwable? = null
)