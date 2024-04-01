package com.juanfra.carticasmagic

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForeignName (
    val name: String?,
    val text: String?,
    val type: String?,
    val flavor: String?,
    val imageUrl: String?,
    val language: String?,
    val multiverseid: Int?
) : Parcelable