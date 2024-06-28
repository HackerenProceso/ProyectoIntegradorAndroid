package com.tecsup.mitiendita.terminos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class TerminosAdapter(val list: List<Terminos>): RecyclerView.Adapter<TerminosViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerminosViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        return TerminosViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TerminosViewHolder, position: Int) {
        val terminos = list[position]
        holder.data(terminos)
    }

}