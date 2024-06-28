package com.tecsup.mitiendita.favoritos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.api.productos
import java.util.ArrayList

class AdaptadorFavoritos(private val listaFav: ArrayList<productos>) :
    RecyclerView.Adapter<AdaptadorFavoritos.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.tvNomProductoFav)
        val descripcion: TextView = itemView.findViewById(R.id.tvDescripcionFav)
        val precio: TextView = itemView.findViewById(R.id.tvPrecioFav)
        val imagen: ImageView = itemView.findViewById(R.id.ivImagenFav)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_fav, parent, false)
        return ViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return listaFav.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = listaFav[position]
        holder.nombre.text = producto.nombre
        holder.descripcion.text = producto.descripcion
        holder.precio.text = producto.precio

        producto.imagenes[0].imagen.let { url ->
            Glide.with(holder.itemView.context)
                .load(url)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.imagen)
        }
    }

}