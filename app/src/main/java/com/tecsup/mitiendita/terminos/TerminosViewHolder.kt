package com.tecsup.mitiendita.terminos

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.mitiendita.R


class TerminosViewHolder (inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_terminos, parent, false)) {

    private var txtterminos: TextView? = null
    private var txtcontenidoT: TextView? = null


    init {
        txtterminos = itemView.findViewById(R.id.txtterminos)
        txtcontenidoT = itemView.findViewById(R.id.txtcontenidoT)

    }

    fun data(terminos: Terminos){
        txtterminos?.text = terminos.terminos
        txtcontenidoT?.text = terminos.textoTerminos

    }

}
