package com.desafio_android_gustavo_rocha.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
data class Price(val price: BigDecimal) : Parcelable