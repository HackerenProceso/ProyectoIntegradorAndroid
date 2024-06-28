package com.tecsup.mitiendita.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.carrito.CarritoActivity
import com.tecsup.mitiendita.favoritos.FavoritosActivity
import com.tecsup.mitiendita.notificacion.NotificacionActivity
import com.tecsup.mitiendita.usuario.UsuarioActivity

class NavFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_nav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nav: BottomNavigationView = view.findViewById(R.id.bottom_navigation)

        nav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(context,HomeActivity::class.java))
                    true
                }
                R.id.navigation_carrito -> {
                    startActivity(Intent(context,CarritoActivity::class.java))
                    true
                }
                R.id.navigation_notificaciones -> {
                    startActivity(Intent(context, NotificacionActivity::class.java))
                    true
                }
                R.id.navigation_favoritos -> {
                    startActivity(Intent(context,FavoritosActivity::class.java))
                    true
                }
                R.id.navigation_usuario -> {
                    startActivity(Intent(context, UsuarioActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}