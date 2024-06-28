package com.tecsup.tecsupapp.notas

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.nosotros.Nosotros


class SobreNosotrosViewHolder(inflater: LayoutInflater, parent: ViewGroup)
    : RecyclerView.ViewHolder(inflater.inflate(R.layout.sobrenosotros_contenido, parent, false)) {

    private var txtnosotros: TextView? = null
    private var btnnosotros: Button? = null

    init {
        txtnosotros = itemView.findViewById(R.id.txtnosotros)
        btnnosotros = itemView.findViewById(R.id.btnnosotros)
    }

    fun data(nota: Nosotros) {
        txtnosotros?.text = nota.texto
        btnnosotros?.text = nota.boton
    }
}
