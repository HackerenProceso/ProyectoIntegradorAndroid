package com.tecsup.mitiendita.contenido

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.gson.Gson
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.api.productos
import java.util.ArrayList

class ProductoViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_contenido, parent, false)) {

    private var contenidoTitulo: TextView? = null
    private var contenidoDescripcion: TextView? = null
    private var contenidoPrecio: TextView? = null
    private var imgproducto: ImageView? = null

    private val fav: ImageView = itemView.findViewById(R.id.iconFavoritos)
    private val add: ImageView = itemView.findViewById(R.id.iconAgregar)
    private var estadoFav:Boolean = true
    private var estadoAdd:Boolean = true

    init {
        contenidoTitulo = itemView.findViewById(R.id.contenidoTitulo)
        contenidoDescripcion = itemView.findViewById(R.id.contenidoDescripcion)
        contenidoPrecio = itemView.findViewById(R.id.contenidoPrecio)
        imgproducto = itemView.findViewById(R.id.imgproducto)
    }

    fun data(item: productos,carrito: ArrayList<productos>,favoritos: ArrayList<productos>, context: Context)/*titulo: String, descripcion: String, precio: String, imagen: String*/ {
        contenidoTitulo?.text = item.nombre
        contenidoDescripcion?.text = item.descripcion
        contenidoPrecio?.text = item.precio
        var imagen = "https://t3.ftcdn.net/jpg/03/45/05/92/360_F_345059232_CPieT8RIWOUk4JqBkkWkIETYAkmz2b75.jpg"

        if (item.imagenes.isNotEmpty()){
            imagen = item.imagenes[0].imagen
        }

        imagen.let { url ->
            imgproducto?.let {
                Glide.with(itemView.context)
                    .load(url) // Carga la imagen desde la URL
                    .skipMemoryCache(true) // Evita almacenar la imagen en la memoria caché
                    .diskCacheStrategy(DiskCacheStrategy.NONE) // Evita almacenar la imagen en la caché de disco
                    .into(it) // Asigna la imagen al ImageView
            }
        }

        carrito.forEach {
            if(it.id == item.id){
                add.setImageResource(R.drawable.quitar_producto)
                estadoFav = !estadoFav
            }
        }

        favoritos.forEach {
            if(it.id == item.id){
                fav.setImageResource(R.drawable.icono_favoritos)
                estadoFav = !estadoFav
            }
        }

        fav.setOnClickListener{
            if(estadoFav){
                fav.setImageResource(R.drawable.icono_favoritos)
                favoritos.add(item)
                guardarSharedPreferences(context,favoritos,"favoritos")
            } else {
                fav.setImageResource(R.drawable.favorito)
                favoritos.remove(item)
                guardarSharedPreferences(context,favoritos,"favoritos")
            }
            estadoFav = !estadoFav
        }

        add.setOnClickListener{
            if(estadoAdd){
                add.setImageResource(R.drawable.quitar_producto)
                carrito.add(item)
                guardarSharedPreferences(context,carrito,"carrito")
            } else {
                add.setImageResource(R.drawable.agregar)
                carrito.remove(item)
                guardarSharedPreferences(context,carrito,"carrito")
            }
            estadoAdd = !estadoAdd
        }

    }

    private fun guardarSharedPreferences(context: Context,lista: ArrayList<productos>, name: String){
        val sp = context.getSharedPreferences(name, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.clear().apply()

        val jsonString = Gson().toJson(lista)

        editor.putString("productos", jsonString)

        editor.apply()
    }

}
