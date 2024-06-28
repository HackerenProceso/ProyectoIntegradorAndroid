package com.tecsup.mitiendita.favoritos

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.api.productos

class FavoritosActivity : AppCompatActivity() {

    private lateinit var adapter: AdaptadorFavoritos
    private var listaFav = ArrayList<productos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)

        val sp = getSharedPreferences("favoritos", Context.MODE_PRIVATE)
        val jsonString = sp.getString("productos", "")
        val gson = Gson()
        listaFav = gson.fromJson(jsonString, Array<productos>::class.java).toCollection(ArrayList())

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val rvListaFav = findViewById<RecyclerView>(R.id.rvListaFav)
        rvListaFav.layoutManager = LinearLayoutManager(this)
        adapter = AdaptadorFavoritos(listaFav)
        rvListaFav.adapter = adapter
    }
}