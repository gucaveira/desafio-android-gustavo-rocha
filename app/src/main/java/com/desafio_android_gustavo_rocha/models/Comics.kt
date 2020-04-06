package com.desafio_android_gustavo_rocha.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Comics(
    val id: Int,
    val digitalId: String?,
    val title: String?,
    val issueNumber: String?,
    val variantDescription: String?,
    val description: String?,
    val modified: String?,
    val isbn: String?,
    val upc: String?,
    val diamondCode: String?,
    val ean: String?,
    val issn: String?,
    val format: String?,
    val pageCount: Int,
    val series: Item?,
    val dateMeus: MutableList<DateMeu>?,
    val prices: MutableList<Price>?,
    val creators: CollectionItem?,
    val characters: CollectionItem?,
    val comics: CollectionItem?,
    val resourceURI: String,
    val startYear: Int,
    val endYear: Int,
    val thumbnail: Thumbnail?,
    val images: MutableList<Thumbnail>?,
    val urls: MutableList<ItemUrl>?,
    var page: Int,
    var fullName: String?
) : Parcelable