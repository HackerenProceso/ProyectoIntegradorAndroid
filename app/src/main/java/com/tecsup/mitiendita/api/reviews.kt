package com.tecsup.mitiendita.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class reviews(
    @SerializedName("id") val id: Int,
    @SerializedName("comentario") val comentario: String,
    @SerializedName("estrellas") val estrellas: Int,
    @SerializedName("cliente") val cliente: Int,
    @SerializedName("producto") val producto: Int
): Serializable
