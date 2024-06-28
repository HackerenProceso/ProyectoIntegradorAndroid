package com.tecsup.mitiendita.cupones

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.mitiendita.R

class CuponViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_cupon, parent, false)) {
    private var codigo: TextView? = null
    private var expiracion: TextView? = null
    private var descuento: TextView? = null
    private var cliente: TextView? = null
    private var aplicarButton: Button? = null

    init {
        codigo = itemView.findViewById(R.id.codigoCupon)
        expiracion = itemView.findViewById(R.id.fechaDescuento)
        descuento = itemView.findViewById(R.id.descuentoText)
        cliente = itemView.findViewById(R.id.detallesDescuento)
        aplicarButton = itemView.findViewById(R.id.aplicarButton)
    }

    fun data(codigo: String, expiracion: String, descuento: String, cliente: String) {
        this.codigo?.text = "Codigo: $codigo"
        this.expiracion?.text = expiracion
        this.descuento?.text = descuento
        this.cliente?.text = cliente

        // Configurar el botón "Aplicar" si es necesario
        aplicarButton?.setOnClickListener {
            // Aquí puedes añadir la lógica para el botón "Aplicar"
        }
    }
}

