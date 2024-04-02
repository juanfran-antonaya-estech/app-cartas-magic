package com.juanfra.carticasmagic

import android.content.res.AssetManager
import java.io.IOException
import java.io.InputStream
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Helper() {
    private lateinit var assets: AssetManager
    companion object {
        private lateinit var lastcardarray: ArrayList<Carta>

        fun setLCA(lastcardarray: ArrayList<Carta>) { this.lastcardarray = lastcardarray }
        fun getLCA() : ArrayList<Carta>{
            return lastcardarray
        }
    }

    fun cargarJson(filename: String, assets: AssetManager): String? {
        this.assets = assets
        var json: String? = null
        try {
            val inputStream: InputStream = assets.open("$filename.json")
            json = inputStream.bufferedReader().use {
                it.readText()
            }
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    fun getImageLang(carta: Carta, language: String): String? {
        if (carta.foreignNames.isNullOrEmpty()) {
            return carta.imageUrl
        } else if (language.equals("English")){
            return carta.imageUrl
        } else {
            for (i in carta.foreignNames) {
                if (i.language.equals(language)){
                    return i.imageUrl
                }
            }
        }
        return null
    }

    fun getNameLang(carta: Carta, language: String): String? {
        if (carta.foreignNames.isNullOrEmpty()) {
            return carta.name
        } else if (language.equals("English")){
            return carta.name
        } else {
            for (i in carta.foreignNames) {
                if (i.language.equals(language)){
                    return i.name
                }
            }
        }
        return null
    }

    fun getTypeLang(carta: Carta, language: String): String? {
        if (carta.foreignNames.isNullOrEmpty()) {
            return carta.type
        } else if (language.equals("English")){
            return carta.type
        } else {
            for (i in carta.foreignNames) {
                if (i.language.equals(language)){
                    return i.type
                }
            }
        }
        return null
    }

    fun getTextLang(carta: Carta, language: String): String? {
        if (carta.foreignNames.isNullOrEmpty()) {
            return carta.text
        } else if (language.equals("English")){
            return carta.text
        } else {
            for (i in carta.foreignNames) {
                if (i.language.equals(language)){
                    return i.text
                }
            }
        }
        return null
    }

    fun getFlavorLang(carta: Carta, language: String): String? {
        if (carta.foreignNames.isNullOrEmpty()) {
            return carta.flavor
        } else if (language.equals("English")){
            return carta.flavor
        } else {
            for (i in carta.foreignNames) {
                if (i.language.equals(language)){
                    return i.flavor
                }
            }
        }
        return null
    }
    fun getIdiomas(carta: Carta): ArrayList<SimpLang> {

        var listado = arrayListOf(SimpLang(carta.imageUrl, "English"))

        for (i in carta.foreignNames!!){
            listado.add(SimpLang(i.imageUrl, i.language))
        }
        return listado
    }

    fun conseguirListadoCartas(jsonString: String?): ArrayList<Carta> {
        val stringparseado = jsonString?.replace("http", "https")
        val gson = Gson()
        val typeOf = TypeToken.getParameterized(ArrayList::class.java, Carta::class.java).type
        setLCA(gson.fromJson<ArrayList<Carta>>(stringparseado, typeOf))
        return getLCA()
    }

}
