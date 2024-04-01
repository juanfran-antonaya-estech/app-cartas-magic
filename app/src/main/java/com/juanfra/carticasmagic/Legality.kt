package com.juanfra.carticasmagic

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Legality (
    val format: String?,
    val legality: String?
) : Parcelable