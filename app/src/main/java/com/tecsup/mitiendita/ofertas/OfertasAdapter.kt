
package com.tecsup.mitiendita.ofertas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.mitiendita.api.categoria


class OfertasAdapter(private val categorias: List<categoria>) : RecyclerView.Adapter<OfertasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfertasViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        return OfertasViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = categorias.size

    override fun onBindViewHolder(holder: OfertasViewHolder, position: Int) {
        val categoria = categorias[position]
        val id = categoria.id
        var nombre = ""
        nombre = if(categoria.nombre.contains(",")){
            categoria.nombre.substringBefore(",")
        }else if(categoria.nombre.contains(" ")){
            categoria.nombre.substringBefore(" ")
        }else
            categoria.nombre
        val imagen = categoria.imagen
        holder.data(nombre,imagen,id)
    }

}
