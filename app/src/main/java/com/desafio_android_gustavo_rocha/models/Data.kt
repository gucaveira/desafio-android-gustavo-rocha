package com.desafio_android_gustavo_rocha.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data (val type : String?, val data : String?) : Parcelable