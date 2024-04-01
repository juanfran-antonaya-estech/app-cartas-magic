package com.juanfra.carticasmagic

import android.content.res.AssetManager
import android.content.res.loader.AssetsProvider
import java.io.IOException
import java.io.InputStream
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Helper() {
    fun cargarJson(filename: String, assets: AssetManager): String? {
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
        } else if (language.equals("english")){
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
        } else if (language.equals("english")){
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
        } else if (language.equals("english")){
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

    fun conseguirListadoCartas(jsonString: String?): ArrayList<Carta> {
        val gson = Gson()
        val typeOf = TypeToken.getParameterized(ArrayList::class.java, Carta::class.java).type
        return gson.fromJson<ArrayList<Carta>>(jsonString, typeOf)
    }
}
