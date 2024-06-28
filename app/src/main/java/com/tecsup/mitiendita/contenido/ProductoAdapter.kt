package com.tecsup.mitiendita.contenido

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.tecsup.mitiendita.api.productos
import java.util.ArrayList

class ProductoAdapter(val context: Context, var productos:ArrayList<productos>, private var carrito: ArrayList<productos>,private var favoritos: ArrayList<productos>): RecyclerView.Adapter<ProductoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductoViewHolder(layoutInflater, parent)
    }

    override fun getItemCount(): Int = productos.size

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val item = productos[position]
        holder.data(item, carrito, favoritos, context)
    }



}