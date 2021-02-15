package com.desafio_android_gustavo_rocha.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Item(val resourceURI: String, val name: String, val type: String?, val role : String? , var image : String?) : Parcelable