package com.juanfra.carticasmagic

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Carta (
    val name: String?,
    val manaCost: String?,
    val cmc: Double?,
    val colors: ArrayList<String>?,
    val colorIdentity: ArrayList<String>?,
    val type: String?,
    val types: ArrayList<String>?,
    val subtypes: ArrayList<String>,
    val rarity: String?,
    val set: String?,
    val setName: String?,
    val text: String?,
    val flavor: String?,
    val artist: String?,
    val number: String?,
    val power: String?,
    val toughness: String?,
    val layout: String?,
    val multiverseid: String?,
    val imageUrl: String?,
    val variations: String?,
    val foreignNames: ArrayList<ForeignName>?,
    val printings: ArrayList<String>?,
    val originalText: String?,
    val originalType: String?,
    val legalities: ArrayList<Legality>?,
    val id: String?
) : Parcelable