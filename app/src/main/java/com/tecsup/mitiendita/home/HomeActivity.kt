package com.tecsup.mitiendita.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.lifecycleScope
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.contacto.ContactoActivity
import com.tecsup.mitiendita.contenido.ScrollingFragment
import com.tecsup.mitiendita.experiencia.ExperienciaActivity
import com.tecsup.mitiendita.ofertas.OfertasActivity
import com.tecsup.mitiendita.reclamos.ReclamosActivity
import com.tecsup.mitiendita.sobreNosotros.SobreNosotrosActivity
import com.tecsup.mitiendita.terminos.TerminosActivity
import com.tecsup.mitiendita.ubicacion.MapActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<ScrollingFragment>(R.id.fragmentScroll)
            }
        }

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<NavFragment>(R.id.fragmentNav)
            }
        }

        lifecycleScope.launch {
            delay(50)
            filtroCategoria(0) }

        val btnBuscar = findViewById<ImageView>(R.id.btnBuscar)
        val EditBusqueda = findViewById<EditText>(R.id.EditBusqueda)

        btnBuscar.setOnClickListener {
            var texto = EditBusqueda.text.toString().trim().lowercase()
            filtroProducto(texto)
        }

        val btntodo = findViewById<Button>(R.id.btntodo)
        val btnbebidas = findViewById<Button>(R.id.btnbebidas)
        val btnhigiene = findViewById<Button>(R.id.btnhigiene)
        val btnlimpieza = findViewById<Button>(R.id.btnlimpieza)
        val btnmascotas = findViewById<Button>(R.id.btnmascotas)
        val btnabarrotes = findViewById<Button>(R.id.btnabarrotes)
        val btnfrutasv = findViewById<Button>(R.id.btnfrutasv)
        val btncongelados = findViewById<Button>(R.id.btncongelados)
        val btnquesos = findViewById<Button>(R.id.btnquesos)
        val btnpan = findViewById<Button>(R.id.btnpan)
        val btncarne = findViewById<Button>(R.id.btncarne)
        val btnlacteos = findViewById<Button>(R.id.btnlacteos)
        val btnsaludable = findViewById<Button>(R.id.btnsaludable)
        val btndesayuno = findViewById<Button>(R.id.btndesayuno)
        val btnbebe = findViewById<Button>(R.id.btnbebe)

        btntodo.setOnClickListener { filtroCategoria(0) }
        btnbebidas.setOnClickListener { filtroCategoria(1) }
        btnhigiene.setOnClickListener { filtroCategoria(2) }
        btnlimpieza.setOnClickListener { filtroCategoria(3) }
        btnmascotas.setOnClickListener { filtroCategoria(4) }
        btnabarrotes.setOnClickListener { filtroCategoria(5) }
        btnfrutasv.setOnClickListener { filtroCategoria(6) }
        btncongelados.setOnClickListener { filtroCategoria(7) }
        btnquesos.setOnClickListener { filtroCategoria(8) }
        btnpan.setOnClickListener { filtroCategoria(9) }
        btncarne.setOnClickListener { filtroCategoria(10) }
        btnlacteos.setOnClickListener { filtroCategoria(11) }
        btnsaludable.setOnClickListener { filtroCategoria(12) }
        btndesayuno.setOnClickListener { filtroCategoria(13) }
        btnbebe.setOnClickListener { filtroCategoria(14) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal_02, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemInicio -> startActivity(Intent(this, HomeActivity::class.java))
            R.id.itemNosotros -> startActivity(Intent(this, SobreNosotrosActivity::class.java))
            R.id.itemOfertas -> startActivity(Intent(this, OfertasActivity::class.java))
            R.id.itemUbicacion -> startActivity(Intent(this, MapActivity::class.java))
            R.id.itemContacto -> startActivity(Intent(this, ContactoActivity::class.java))
            R.id.itemReclamo -> startActivity(Intent(this, ReclamosActivity::class.java))
            R.id.itemTerminos -> startActivity(Intent(this, TerminosActivity::class.java))
            R.id.itemExperiencia -> startActivity(Intent(this, ExperienciaActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun filtroProducto(texto: String) {
        val fragmento = supportFragmentManager.findFragmentById(R.id.fragmentScroll) as? ScrollingFragment
        fragmento?.filtrarProducto(texto)
    }

    private fun filtroCategoria(categoria: Int) {
        val fragmento = supportFragmentManager.findFragmentById(R.id.fragmentScroll) as? ScrollingFragment
        fragmento?.buscarProducto(categoria)
    }
}
