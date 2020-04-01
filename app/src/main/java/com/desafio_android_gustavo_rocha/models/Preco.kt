package com.desafio_android_gustavo_rocha.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Preco (val type : String?, val preco: Double) : Parcelable