package com.tecsup.mitiendita.cupones

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.mitiendita.api.cupon

class CuponAdapter(private val cupones:List<cupon>): RecyclerView.Adapter<CuponViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuponViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CuponViewHolder(layoutInflater, parent)
    }

    override fun getItemCount(): Int = cupones.size

    override fun onBindViewHolder(holder: CuponViewHolder, position: Int) {
        val item = cupones[position]
        val codigo = item.codigo
        val descuento = item.descuento
        val expiracion = item.expiracion
        var cliente = ""
        if(item.cliente != null){
            cliente = item.cliente
        }
        holder.data(codigo, expiracion, descuento, cliente)
    }

}