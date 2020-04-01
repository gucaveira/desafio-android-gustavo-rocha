package com.desafio_android_gustavo_rocha.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ColecaoItem(
    val disponivel: Int, val colecaoURL: String?,
    val items: MutableList<Item>?, val returned: Int
) : Parcelable