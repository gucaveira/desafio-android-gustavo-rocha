package com.desafio_android_gustavo_rocha.models

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize


@Entity(primaryKeys = ["id"])
@Parcelize
data class Personagem(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    @Embedded(prefix = "thumbnail_")
    val thumbnail: Thumbnail,
    val resourceURI: String?,
    @Embedded(prefix = "comics_")
    val comics: ColecaoItem,
    @Embedded(prefix = "series_")
    val series: ColecaoItem,
    @Embedded(prefix = "stories_")
    val stories: ColecaoItem,
    @Embedded(prefix = "events_")
    val events: ColecaoItem,
    val urls: MutableList<ItemUrl>,
    var page: Int
) : Parcelable