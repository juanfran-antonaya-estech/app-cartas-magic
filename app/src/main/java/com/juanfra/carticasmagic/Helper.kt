package com.juanfra.carticasmagic

import java.io.IOException
import java.io.InputStream
import androidx.appcompat.app.AppCompatActivity

class Helper(val filename: String): AppCompatActivity() {
    fun cargarJson(): String? {
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
}
