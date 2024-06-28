package com.tecsup.mitiendita.contenido

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.api.ApiService
import com.tecsup.mitiendita.api.SharedPreference
import com.tecsup.mitiendita.api.productos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.collections.ArrayList

class ScrollingFragment : Fragment() {

    private lateinit var adapter: ProductoAdapter
    private val listContenido = ArrayList<productos>()
    private var carrito = ArrayList<productos>()
    private var favoritos = ArrayList<productos>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_contenido, container, false)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://mitiendita.fun/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun buscarProducto(categoria: Int) {
        if (categoria != -1) {
            viewLifecycleOwner.lifecycleScope.launch {
                try {
                    val productos = withContext(Dispatchers.IO) {
                        // Intenta obtener productos desde SharedPreferences
                        val cachedProducts = SharedPreference().obtenerProductosDeSharedPreferences(requireContext())
                        if (cachedProducts != null) {
                            cachedProducts
                        } else {
                            // Si no hay productos en caché, llama a la API
                            val fetchedProducts = fetchProductosFromApi()
                            // Guarda los productos obtenidos de la API en SharedPreferences
                            fetchedProducts?.let {
                                SharedPreference().guardarProductosEnSharedPreferences(requireContext(), it)
                            }
                            fetchedProducts
                        }
                    }
                    if (productos != null) {
                        listContenido.clear()
                        if (categoria == 0) {
                            listContenido.addAll(productos)
                        } else {
                            listContenido.addAll(productos.filter { it.categoria.id == categoria })
                        }
                        adapter.notifyDataSetChanged()
                    } else {
                        showError()
                    }
                } catch (e: Exception) {
                    showError()
                }
            }
        }
    }

    private fun fetchProductosFromApi(): List<productos>? {
        return try {
            val call = getRetrofit().create(ApiService::class.java).obtenerProductos()
            val response = call.execute()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    fun filtrarProducto(nombre: String) {
        viewLifecycleOwner.lifecycleScope.launch{
            try {
                val productos = withContext(Dispatchers.IO) {
                    val cachedProducts = SharedPreference().obtenerProductosDeSharedPreferences(requireContext())
                    cachedProducts
                }

                if (productos != null) {
                    listContenido.clear()
                    if (nombre == "") {
                        listContenido.addAll(productos)
                    } else {
                        listContenido.addAll(productos.filter {
                            it.nombre.trim().lowercase().contains(nombre)})
                    }
                    adapter.notifyDataSetChanged()
                } else {
                    showError()
                }

            } catch (e: Exception) {
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
        buscarProducto(-1)
    }

    private fun initRecyclerView() {
        val sp = requireContext().getSharedPreferences("carrito", Context.MODE_PRIVATE)
        val jsonString = sp.getString("productos", "")

        val sp2 = requireContext().getSharedPreferences("carrito", Context.MODE_PRIVATE)
        val jsonString2 = sp2.getString("productos", "")

        if (!jsonString.isNullOrEmpty()) {
            carrito = Gson().fromJson(jsonString, Array<productos>::class.java).toCollection(ArrayList())
        }

        if (!jsonString2.isNullOrEmpty()) {
            favoritos = Gson().fromJson(jsonString2, Array<productos>::class.java).toCollection(ArrayList())
        }

        val recyclerView: RecyclerView = requireView().findViewById(R.id.contenidoProducto)
        adapter = ProductoAdapter(requireContext(), listContenido, carrito, favoritos)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter
    }
}
