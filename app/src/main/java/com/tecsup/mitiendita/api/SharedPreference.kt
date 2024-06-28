package com.tecsup.mitiendita.api

import android.content.Context
import android.content.SharedPreferences
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class SharedPreference {
    private val PREFERENCES_NAME = "app_prefs"
    private val KEY_PRODUCTOS = "productos"

    fun guardarProductosEnSharedPreferences(context: Context, productos: List<productos>) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(productos)
        editor.putString(KEY_PRODUCTOS, json)
        editor.apply()
    }

    fun obtenerProductosDeSharedPreferences(context: Context): List<productos>? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString(KEY_PRODUCTOS, null)
        return if (json != null) {
            val type = object : TypeToken<List<productos>>() {}.type
            gson.fromJson(json, type)
        } else {
            null
        }
    }

    fun clearSharedPreferences(context: Context) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        val favoritos: SharedPreferences = context.getSharedPreferences("favoritos", Context.MODE_PRIVATE)
        val carrito: SharedPreferences = context.getSharedPreferences("carrito", Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
        editor = favoritos.edit()
        editor.clear()
        editor.apply()
        editor = carrito.edit()
        editor.clear()
        editor.apply()
    }
}