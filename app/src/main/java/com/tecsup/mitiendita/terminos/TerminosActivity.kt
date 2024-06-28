package com.tecsup.mitiendita.terminos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
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
import com.tecsup.mitiendita.ubicacion.MapActivity

class TerminosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terminos)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<NavFragment>(R.id.fragmentNav)
            }
        }

        val txtterminos = findViewById<TextView>(R.id.txtterminos)
        val txtcontenidoT = findViewById<TextView>(R.id.txtcontenidoT)

        // Aquí puedes actualizar el texto si es necesario
        txtterminos.text = "Estimado cliente."
        txtcontenidoT.text = """
            Conforme a lo establecido en el Reglamento del Libro de reclamaciones del Código de Protección y Defensa del consumidor ponemos a tu disposición nuestro Libro de reclamaciones Virtual.
            A través de nuestro Libro de Reclamaciones Virtual podrás presentar un reclamo o queja respecto a tu disconformidad por un producto o servicio ofrecido por nosotros.
            Te informamos que los datos que ingreses al momento de presentar tu reclamo o queja, a través de nuestro Libro de reclamaciones Virtual, serán tratados conforme nuestra Políticas de Datos Personales, con la finalidad de gestionar y dar respuesta al mismo, dentro del plazo legal.
            Accede a nuestro Libro de Reclamaciones Virtual dando clic al botón.
            Conforme a lo establecido en el Reglamento del Libro de reclamaciones del Código de Protección y Defensa del consumidor ponemos a tu disposición nuestro Libro de reclamaciones Virtual.
            A través de nuestro Libro de Reclamaciones Virtual podrás presentar un reclamo o queja respecto a tu disconformidad por un producto o servicio ofrecido por nosotros.
            Te informamos que los datos que ingreses al momento de presentar tu reclamo o queja, a través de nuestro Libro de reclamaciones Virtual, serán tratados conforme nuestra Políticas de Datos Personales, con la finalidad de gestionar y dar respuesta al mismo, dentro del plazo legal.
            Accede a nuestro Libro de Reclamaciones Virtual dando clic al botón.
            Conforme a lo establecido en el Reglamento del Libro de reclamaciones del Código de Protección y Defensa del consumidor ponemos a tu disposición nuestro Libro de reclamaciones Virtual.
            A través de nuestro Libro de Reclamaciones Virtual podrás presentar un reclamo o queja respecto a tu disconformidad por un producto o servicio ofrecido por nosotros.
            Te informamos que los datos que ingreses al momento de presentar tu reclamo o queja, a través de nuestro Libro de reclamaciones Virtual, serán tratados conforme nuestra Políticas de Datos Personales, con la finalidad de gestionar y dar respuesta al mismo, dentro del plazo legal.
            Accede a nuestro Libro de Reclamaciones Virtual dando clic al botón A través de nuestro Libro de Reclamaciones Virtual podrás presentar un reclamo o queja respecto a tu disconformidad por un producto o servicio ofrecido por nosotros.
            Te informamos que los datos que ingreses al momento de presentar tu reclamo o queja, a través de nuestro Libro de reclamaciones Virtual, serán tratados conforme nuestra Políticas de Datos Personales, con la finalidad de gestionar y dar respuesta al mismo, dentro del plazo legal.
            Accede a nuestro Libro de Reclamaciones Virtual dando clic al botón.
            Conforme a lo establecido en el Reglamento del Libro de reclamaciones del Código de Protección y Defensa del consumidor ponemos a tu disposición nuestro Libro de reclamaciones Virtual.
            A través de nuestro Libro de Reclamaciones Virtual podrás presentar un reclamo o queja respecto a tu disconformidad por un producto o servicio ofrecido por nosotros.
            Te informamos que los datos que ingreses al momento de presentar tu reclamo o queja, a través de nuestro Libro de reclamaciones Virtual, serán tratados conforme nuestra Políticas de Datos Personales, con la finalidad de gestionar y dar respuesta al mismo, dentro del plazo legal.
            Accede a nuestro Libro de Reclamaciones Virtual dando clic al botón.
            Conforme a lo establecido en el Reglamento del Libro de reclamaciones del Código de Protección y Defensa del consumidor ponemos a tu disposición nuestro Libro de reclamaciones Virtual.
            A través de nuestro Libro de Reclamaciones Virtual podrás presentar un reclamo o queja respecto a tu disconformidad por un producto o servicio ofrecido por nosotros.
            Te informamos que los datos que ingreses al momento de presentar tu reclamo o queja, a través de nuestro Libro de reclamaciones Virtual, serán tratados conforme nuestra Políticas de Datos Personales, con la finalidad de gestionar y dar respuesta al mismo, dentro del plazo legal.
            Accede a nuestro Libro de Reclamaciones Virtual dando clic al botón A través de nuestro Libro de Reclamaciones Virtual podrás presentar un reclamo o queja respecto a tu disconformidad por un producto o servicio ofrecido por nosotros.
            Te informamos que los datos que ingreses al momento de presentar tu reclamo o queja, a través de nuestro Libro de reclamaciones Virtual, serán tratados conforme nuestra Políticas de Datos Personales, con la finalidad de gestionar y dar respuesta al mismo, dentro del plazo legal.
            Accede a nuestro Libro de Reclamaciones Virtual dando clic al botón.
            Conforme a lo establecido en el Reglamento del Libro de reclamaciones del Código de Protección y Defensa del consumidor ponemos a tu disposición nuestro Libro de reclamaciones Virtual.
            A través de nuestro Libro de Reclamaciones Virtual podrás presentar un reclamo o queja respecto a tu disconformidad por un producto o servicio ofrecido por nosotros.
            Te informamos que los datos que ingreses al momento de presentar tu reclamo o queja, a través de nuestro Libro de reclamaciones Virtual, serán tratados conforme nuestra Políticas de Datos Personales, con la finalidad de gestionar y dar respuesta al mismo, dentro del plazo legal.
            Accede a nuestro Libro de Reclamaciones Virtual dando clic al botón.
            Conforme a lo establecido en el Reglamento del Libro de reclamaciones del Código de Protección y Defensa del consumidor ponemos a tu disposición nuestro Libro de reclamaciones Virtual.
            A través de nuestro Libro de Reclamaciones Virtual podrás presentar un reclamo o queja respecto a tu disconformidad por un producto o servicio ofrecido por nosotros.
            Te informamos que los datos que ingreses al momento de presentar tu reclamo o queja, a través de nuestro Libro de reclamaciones Virtual, serán tratados conforme nuestra Políticas de Datos Personales, con la finalidad de gestionar y dar respuesta al mismo, dentro del plazo legal.
            Accede a nuestro Libro de Reclamaciones Virtual dando clic al botón.
        """.trimIndent()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal_02, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemInicio -> {
                startActivity(Intent(this, HomeActivity::class.java))
                return true
            }
            R.id.itemNosotros -> {
                startActivity(Intent(this, SobreNosotrosActivity::class.java))
                return true
            }
            R.id.itemOfertas -> {
                startActivity(Intent(this, OfertasActivity::class.java))
                return true
            }
            R.id.itemUbicacion -> {
                startActivity(Intent(this, MapActivity::class.java))
                return true
            }
            R.id.itemContacto -> {
                startActivity(Intent(this, ContactoActivity::class.java))
                return true
            }
            R.id.itemReclamo -> {
                startActivity(Intent(this, ReclamosActivity::class.java))
                return true
            }
            R.id.itemTerminos -> {
                startActivity(Intent(this, TerminosActivity::class.java))
                return true
            }
            R.id.itemExperiencia -> {
                startActivity(Intent(this, ExperienciaActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
