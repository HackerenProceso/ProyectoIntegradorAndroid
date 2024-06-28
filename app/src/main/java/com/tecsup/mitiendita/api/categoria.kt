package com.tecsup.mitiendita.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class categoria(
    @SerializedName("id") val id: Int,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("descripcion") val descripcion: String,
    @SerializedName("imagen") val imagen: String
): Serializable
