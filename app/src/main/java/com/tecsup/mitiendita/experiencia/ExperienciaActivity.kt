package com.tecsup.mitiendita.experiencia


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.home.HomeActivity
import com.tecsup.mitiendita.home.NavFragment
import com.tecsup.mitiendita.ofertas.OfertasActivity
import com.tecsup.mitiendita.reclamos.ReclamosActivity
import com.tecsup.mitiendita.sobreNosotros.SobreNosotrosActivity
import com.tecsup.mitiendita.terminos.TerminosActivity
import com.tecsup.mitiendita.ubicacion.MapActivity

class ExperienciaActivity : AppCompatActivity() {

    private lateinit var calificacion: RatingBar
    private lateinit var comentario: EditText
    private lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.evalua_experiencia)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<NavFragment>(R.id.fragmentNav)
            }
        }

        calificacion = findViewById(R.id.calificacion)
        comentario = findViewById(R.id.comentario)
        submitBtn = findViewById(R.id.submitBtn)

        submitBtn.setOnClickListener {
            val estrellas = calificacion.rating
            val comentarioTexto = comentario.text.toString()

            sendEmail(estrellas, comentarioTexto)
        }
    }

    private fun sendEmail(estrellas: Float, comentario: String) {
        val recipient = "luciabarera4@gmail.com"
        val subject = "Evaluación de experiencia"
        val message = "Calificación: $estrellas\n\nComentario:\n$comentario"

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "message/rfc822"
            putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)
        }

        // Verifica si hay una aplicación de correo instalada que pueda manejar el intent
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(intent, "Enviar correo con:"))
        } else {
            // Manejar el caso donde no hay ninguna aplicación de correo instalada
            Toast.makeText(this, "No hay aplicaciones de correo instaladas.", Toast.LENGTH_SHORT).show()
        }
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
