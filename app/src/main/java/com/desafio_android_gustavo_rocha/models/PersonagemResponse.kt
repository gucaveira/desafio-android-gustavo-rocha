package com.desafio_android_gustavo_rocha.models

data class PersonagemResponse(val code: Int, val status: String, val copyright: String,
                              val attributionText: String, val attributionHTML: String,
                              val etag: String, val data: PersonagemData
)