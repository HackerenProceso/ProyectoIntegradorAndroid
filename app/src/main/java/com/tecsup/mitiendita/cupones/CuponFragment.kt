package com.tecsup.mitiendita.cupones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.api.ApiService
import com.tecsup.mitiendita.api.cupon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CuponFragment : Fragment() {

    private lateinit var adapter: CuponAdapter
    private val listCupones = mutableListOf<cupon>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cupon, container, false)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://mitiendita.fun/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buscarCupon(){
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val call = withContext(Dispatchers.IO) {
                    getRetrofit().create(ApiService::class.java).obtenerCupones()
                }
                val response = withContext(Dispatchers.IO) { call.execute() }
                if (response.isSuccessful) {
                    val cupones = response.body()
                    if (cupones != null) {
                        listCupones.clear()
                        listCupones.addAll(cupones)
                        adapter.notifyDataSetChanged()
                    } else {
                        showError()
                    }
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
        buscarCupon()
    }

    private fun initRecyclerView() {
        val recyclerView: RecyclerView = requireView().findViewById(R.id.cuponesRecycler)
        adapter = CuponAdapter(listCupones)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
}