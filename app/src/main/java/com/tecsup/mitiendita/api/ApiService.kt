package com.tecsup.mitiendita.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET("productos/")
    fun obtenerProductos(): Call<List<productos>>

    @GET("categorias/")
    fun obtenerCategorias(): Call<List<categoria>>

    @GET("cupones/")
    fun obtenerCupones(): Call<List<cupon>>
}