package com.tecsup.mitiendita.notificacion

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.contacto.ContactoActivity
import com.tecsup.mitiendita.experiencia.ExperienciaActivity
import com.tecsup.mitiendita.home.HomeActivity
import com.tecsup.mitiendita.home.NavFragment
import com.tecsup.mitiendita.ofertas.OfertasActivity
import com.tecsup.mitiendita.reclamos.ReclamosActivity
import com.tecsup.mitiendita.sobreNosotros.SobreNosotrosActivity
import com.tecsup.mitiendita.terminos.TerminosActivity
import com.tecsup.mitiendita.ubicacion.MapActivity

class NotificacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notificaciones)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<NavFragment>(R.id.fragmentNav)
            }
        }

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
}