package com.tecsup.mitiendita.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class productos(
    @SerializedName("id") val id: Int,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("precio") val precio: String,
    @SerializedName("descripcion") val descripcion: String,
    @SerializedName("stock") val stock: Int,
    @SerializedName("lote") val lote: String,
    @SerializedName("marca") val marca: marca,
    @SerializedName("categoria") val categoria: categoria,
    @SerializedName("imagenes") val imagenes: List<imgProductos>,
    @SerializedName("reviews") val reviews: List<reviews>?
): Serializable