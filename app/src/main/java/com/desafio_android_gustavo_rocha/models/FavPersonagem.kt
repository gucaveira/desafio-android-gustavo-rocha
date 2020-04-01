package com.desafio_android_gustavo_rocha.models

import androidx.room.Embedded
import androidx.room.Entity


@Entity(primaryKeys = ["personagemId"])
data class FavPersonagem(val personagemId : Int,
                         @Embedded( prefix = "character_")
                         val personagem: Personagem)