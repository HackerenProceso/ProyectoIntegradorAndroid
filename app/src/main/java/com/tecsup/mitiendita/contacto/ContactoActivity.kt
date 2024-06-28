
package com.tecsup.mitiendita.contacto

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.experiencia.ExperienciaActivity
import com.tecsup.mitiendita.home.HomeActivity
import com.tecsup.mitiendita.home.NavFragment
import com.tecsup.mitiendita.ofertas.OfertasActivity
import com.tecsup.mitiendita.reclamos.ReclamosActivity
import com.tecsup.mitiendita.sobreNosotros.SobreNosotrosActivity
import com.tecsup.mitiendita.terminos.TerminosActivity
import com.tecsup.mitiendita.ubicacion.MapActivity

class ContactoActivity : AppCompatActivity() {

    private lateinit var nombresContacto: EditText // inicializamos esta variable
    private lateinit var correoContacto: EditText
    private lateinit var numeroContacto: EditText
    private lateinit var mensajeContacto: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacto)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<NavFragment>(R.id.fragmentNav)
            }
        }

        nombresContacto = findViewById(R.id.nombresContacto) // inicializamos esta variable
        correoContacto = findViewById(R.id.correoContacto)
        numeroContacto = findViewById(R.id.numeroContacto)
        mensajeContacto = findViewById(R.id.mensajeContacto)

        val btnContacto = findViewById<Button>(R.id.btnContacto)
        val btnChatea = findViewById<Button>(R.id.btnChatea)
        val btnVisitanos = findViewById<Button>(R.id.btnVisitanos)

        btnContacto.setOnClickListener {
            val nombre = nombresContacto.text.toString().trim()
            val correo = correoContacto.text.toString().trim()
            val numero = numeroContacto.text.toString().trim()
            val mensaje = mensajeContacto.text.toString().trim()

            if (nombre.isEmpty() || correo.isEmpty() || numero.isEmpty() || mensaje.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos.", Toast.LENGTH_SHORT).show()
            } else {
                sendEmail(nombre, correo, numero, mensaje) // Llamar a la función para enviar el correo
            }
        }

        btnChatea.setOnClickListener {
            openWhatsApp()
        }

        btnVisitanos.setOnClickListener {
            openMapActivity()
        }
    }

    private fun sendEmail(nombre: String, correo: String, numero: String, mensaje: String) { // Función para enviar el correo
        val recipient = "luciabarera4@gmail.com"
        val subject = "Contacto desde la aplicación"
        val message = "Nombre: $nombre\nCorreo: $correo\nNúmero: $numero\n\nMensaje:\n$mensaje"

        val intent = Intent(Intent.ACTION_SEND).apply { // Intent para enviar el correo
            type = "message/rfc822" // Tipo de contenido
            putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient)) // Destinatario
            putExtra(Intent.EXTRA_SUBJECT, subject) //Asunto
            putExtra(Intent.EXTRA_TEXT, message)// Mensaje
        }

        // Verifica si hay una aplicación de correo instalada que pueda manejar el intent
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(intent, "Enviar correo con:"))
        } else {
            // Manejar el caso donde no hay ninguna aplicación de correo instalada
            Toast.makeText(this, "No hay aplicaciones de correo instaladas.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openWhatsApp() {
        val uri = Uri.parse("https://api.whatsapp.com/send?phone=+51906638809")
        val intent = Intent(Intent.ACTION_VIEW, uri) // Intent para abrir WhatsApp
        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "WhatsApp no está instalado.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openMapActivity() {
        val intent = Intent(this, MapActivity::class.java)
        startActivity(intent)
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
                // No es necesario iniciar ContactoActivity desde aquí, ya estás en ContactoActivity
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
