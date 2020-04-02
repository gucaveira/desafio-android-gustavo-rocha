package com.desafio_android_gustavo_rocha.models

import androidx.room.Embedded
import androidx.room.Entity

@Entity(primaryKeys = ["deskItemId"])
data class DeskItem(
    val deskItemId: Int,
    @Embedded(prefix = "item_")
    val item: Comics
)