package com.tecsup.tecsupapp.notas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.mitiendita.nosotros.Nosotros


class SobreNosotrosAdapter(val list: List<Nosotros>) : RecyclerView.Adapter<SobreNosotrosViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SobreNosotrosViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SobreNosotrosViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SobreNosotrosViewHolder, position: Int) {
        val sobrenosotros = list[position]
        holder.data(sobrenosotros)
    }
}
