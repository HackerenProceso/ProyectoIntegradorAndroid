package com.tecsup.mitiendita.ofertascategorias

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.lifecycleScope
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.contenido.ScrollingFragment
import com.tecsup.mitiendita.home.NavFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CarnesActivity : AppCompatActivity() {

    private lateinit var publicidadLayout: LinearLayout
    private val imageList = listOf(
        R.drawable.carnes1,
        R.drawable.carnes2,
        R.drawable.carnes3
    )
    private var currentIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carnes)

        publicidadLayout = findViewById(R.id.publicidadcarnes)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<ScrollingFragment>(R.id.fragmentContenidoOferta)
            }
        }
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<NavFragment>(R.id.fragmentNav)
            }
        }

        lifecycleScope.launch {
            delay(1)
            filtroCategoria(10)
        }

        startImageSlideshow()
    }

    private fun startImageSlideshow() {
        lifecycleScope.launch {
            while (true) {
                delay(3000) // Cambia la imagen cada 3 segundos
                currentIndex = (currentIndex + 1) % imageList.size
                publicidadLayout.setBackgroundResource(imageList[currentIndex])
            }
        }
    }

    private fun filtroCategoria(categoria: Int) {
        val fragmento = supportFragmentManager.findFragmentById(R.id.fragmentContenidoOferta) as? ScrollingFragment
        fragmento?.buscarProducto(categoria)
    }
}