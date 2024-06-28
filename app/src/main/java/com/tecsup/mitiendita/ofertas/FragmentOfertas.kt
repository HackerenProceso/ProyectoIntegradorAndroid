package com.tecsup.mitiendita.ofertas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.api.ApiService
import com.tecsup.mitiendita.api.categoria
import com.tecsup.mitiendita.contenido.ProductoAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FragmentOfertas: Fragment() {

    private lateinit var adapter: OfertasAdapter
    private val listCategoria = mutableListOf<categoria>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ofertas_ofertas, container, false)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://mitiendita.fun/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buscarCategoria(){
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val call = withContext(Dispatchers.IO) { getRetrofit().create(ApiService::class.java).obtenerCategorias() }
                val response = withContext(Dispatchers.IO) { call.execute() }
                if (response.isSuccessful) {
                    val categorias = response.body()
                    if (categorias != null) {
                        listCategoria.clear()
                        listCategoria.addAll(categorias)
                        adapter.notifyDataSetChanged()
                    } else {
                        showError()
                    }
                } else {
                    showError()
                }
            } catch (e: Exception){
                showError()
            }
        }
    }

    private fun showError() {
        Toast.makeText(context, "Error al cargar los datos", Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        buscarCategoria()
    }

    private fun initRecyclerView() {
        val recyclerView: RecyclerView = requireView().findViewById(R.id.recyclerOfertas)
        adapter = OfertasAdapter(listCategoria)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter
    }

}