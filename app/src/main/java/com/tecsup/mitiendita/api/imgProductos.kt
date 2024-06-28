package com.tecsup.mitiendita.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class imgProductos(
    @SerializedName("id") val id: Int,
    @SerializedName("producto") val producto: Int,
    @SerializedName("imagen") val imagen: String
): Serializable
