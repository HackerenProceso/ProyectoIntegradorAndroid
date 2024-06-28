package com.tecsup.mitiendita.ofertas

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.ofertascategorias.AbarrotesActivity
import com.tecsup.mitiendita.ofertascategorias.BebeActivity
import com.tecsup.mitiendita.ofertascategorias.CarnesActivity
import com.tecsup.mitiendita.ofertascategorias.CongeladosActivity
import com.tecsup.mitiendita.ofertascategorias.CuidadoActivity
import com.tecsup.mitiendita.ofertascategorias.DesayunosActivity
import com.tecsup.mitiendita.ofertascategorias.FrutasActivity
import com.tecsup.mitiendita.ofertascategorias.LacteosActivity
import com.tecsup.mitiendita.ofertascategorias.LicoresActivity
import com.tecsup.mitiendita.ofertascategorias.LimpiezaActivity
import com.tecsup.mitiendita.ofertascategorias.MascotasActivity
import com.tecsup.mitiendita.ofertascategorias.PanaderiaActivity
import com.tecsup.mitiendita.ofertascategorias.QuesosActivity
import com.tecsup.mitiendita.ofertascategorias.SaludableActivity


class OfertasViewHolder (inflater: LayoutInflater, parent: ViewGroup)
    : RecyclerView.ViewHolder(inflater.inflate(R.layout.ofertas_contenido, parent, false)) {

    private var imgOfertas: ImageView? = null
    private var tituloOfertas: Button? = null

    init {
        imgOfertas = itemView.findViewById(R.id.imgOfertas)
        tituloOfertas = itemView.findViewById(R.id.btnofertas)
    }

    fun data(nombre: String, imagen: String, id: Int) {
        imagen.let { url ->
            imgOfertas?.let {
                Glide.with(itemView.context)
                    .load(url)
                    .into(it)
            }
        }
        tituloOfertas?.text = nombre
        tituloOfertas?.tag = id
        tituloOfertas?.setOnClickListener {
            when(tituloOfertas?.tag){
                1 -> itemView.context.startActivity(Intent(itemView.context, LicoresActivity::class.java))
                2 -> itemView.context.startActivity(Intent(itemView.context, CuidadoActivity::class.java))
                3 -> itemView.context.startActivity(Intent(itemView.context, LimpiezaActivity::class.java))
                4 -> itemView.context.startActivity(Intent(itemView.context, MascotasActivity::class.java))
                5 -> itemView.context.startActivity(Intent(itemView.context, AbarrotesActivity::class.java))
                6 -> itemView.context.startActivity(Intent(itemView.context, FrutasActivity::class.java))
                7 -> itemView.context.startActivity(Intent(itemView.context, CongeladosActivity::class.java))
                8 -> itemView.context.startActivity(Intent(itemView.context, QuesosActivity::class.java))
                9 -> itemView.context.startActivity(Intent(itemView.context, PanaderiaActivity::class.java))
                10 -> itemView.context.startActivity(Intent(itemView.context, CarnesActivity::class.java))
                11 -> itemView.context.startActivity(Intent(itemView.context, LacteosActivity::class.java))
                12 -> itemView.context.startActivity(Intent(itemView.context, SaludableActivity::class.java))
                13 -> itemView.context.startActivity(Intent(itemView.context, DesayunosActivity::class.java))
                14 -> itemView.context.startActivity(Intent(itemView.context, BebeActivity::class.java))
            }

        }
    }
}
