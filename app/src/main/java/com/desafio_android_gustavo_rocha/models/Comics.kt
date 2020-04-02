package com.desafio_android_gustavo_rocha.models

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize


@Entity(primaryKeys = ["id"])
@Parcelize
data class Comics(
    val id: Int,
    val digitalId: String?,
    val titulo: String?,
    val issueNumber: String?,
    val variantDescription: String?,
    val descricao: String?,
    val modified: String?,
    val isbn: String?,
    val upc: String?,
    val diamondCode: String?,
    val ean: String?,
    val issn: String?,
    val format: String?,
    val pageCount: Int,
    @Embedded(prefix = "series_")
    val series: Item?,
    val data: MutableList<Data>?,
    val precos: MutableList<Preco>?,
    val criadores: ColecaoItem?,
    val personagens: ColecaoItem?,
    val comics: ColecaoItem?,
    val resourceURI: String,
    val startYear: Int,
    val endYear: Int,
    val thumbnail: Thumbnail?,
    val images: MutableList<Thumbnail>?,
    val urls: MutableList<ItemUrl>?,
    var page: Int,
    var fullName: String?
) : Parcelable