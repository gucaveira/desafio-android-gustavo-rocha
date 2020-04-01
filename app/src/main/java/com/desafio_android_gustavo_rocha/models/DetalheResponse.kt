package com.desafio_android_gustavo_rocha.models

data class DetalheResponse(
    val code: Int, val status: String, val copyright: String,
    val attributionText: String, val attributionHTML: String,
    val etag: String, val data: PersonagemDetalheData
)