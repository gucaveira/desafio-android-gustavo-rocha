package com.desafio_android_gustavo_rocha.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CollectionItem(
    val available: Int, val collectionURI: String?,
    val items: MutableList<Item>?, val returned: Int
) : Parcelable