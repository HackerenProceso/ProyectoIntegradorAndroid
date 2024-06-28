package com.tecsup.mitiendita.carrito

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.api.productos
import java.util.ArrayList
import kotlin.math.roundToInt

class AdaptadorCarrito(private val tvTotal: TextView, private val carroCompras: ArrayList<productos>) :
    RecyclerView.Adapter<AdaptadorCarrito.ViewHolder>() {

    private var total: Double = 0.0

    init {
        calcularTotal()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.tvNomProducto)
        val descripcion: TextView = itemView.findViewById(R.id.tvDescripcion)
        val precio: TextView = itemView.findViewById(R.id.tvPrecio)
        val imagen: ImageView = itemView.findViewById(R.id.ivImagen)
        val btnEliminar: ImageButton = itemView.findViewById(R.id.btnEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_carro_compras, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = carroCompras[position]
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

        holder.btnEliminar.setOnClickListener {
            // Eliminar el producto del carrito
            carroCompras.removeAt(position)
            notifyDataSetChanged()
            calcularTotal()
        }
    }

    override fun getItemCount(): Int {
        return carroCompras.size
    }

    private fun calcularTotal() {
        total = 0.0
        carroCompras.forEach {
            total += it.precio.toDouble()
        }
        total = ((total * 100).roundToInt()).toDouble() / 100

        tvTotal.text = "Total: S/ $total" // Actualizar el TextView del total
    }
}
