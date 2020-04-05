package com.desafio_android_gustavo_rocha.models

import androidx.room.Embedded
import androidx.room.Entity


@Entity(primaryKeys = ["characterId"])
data class FavCharacter( val characterId : Int ,
                         @Embedded( prefix = "character_")
                         val character: Character)