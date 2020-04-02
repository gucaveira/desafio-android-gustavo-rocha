package com.desafio_android_gustavo_rocha.models

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize


@Entity(primaryKeys = ["resourceURI"])
@Parcelize
data class Item(
    val resourceURI: String,
    val nome: String,
    val type: String?,
    val role: String?,
    var image: String?
) : Parcelable