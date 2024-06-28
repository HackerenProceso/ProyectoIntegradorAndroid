package com.tecsup.mitiendita.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class cupon(
    @SerializedName("id")val id: Int,
    @SerializedName("codigo")val codigo: String,
    @SerializedName("descuento")val descuento: String,
    @SerializedName("fecha_expiracion")val expiracion: String,
    @SerializedName("cliente_que_lo_uso") val cliente: String?

): Serializable
