package com.desafio_android_gustavo_rocha.api

class ApiResponse<T>(
    val code: Int,
    val body: T?,
    val error: Throwable?

)