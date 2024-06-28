package com.tecsup.mitiendita.reclamos

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.home.NavFragment

class Reclamosfrm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reclamos_frm)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val btnContinuar02 = findViewById<Button>(R.id.btnContinuar02)
        val editTextReclamo = findViewById<EditText>(R.id.editTextReclamo)
        val editTextSolicitud = findViewById<EditText>(R.id.editTextSolicitud)

        btnContinuar02.setOnClickListener {
            if (editTextReclamo.text.isEmpty() || editTextSolicitud.text.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos.", Toast.LENGTH_LONG).show()
            } else {
                //startActivity(Intent(this, Reclamosfrm01::class.java))
                sendEmail(editTextReclamo.text.toString(), editTextSolicitud.text.toString())
            }
        }
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<NavFragment>(R.id.fragmentNav)
            }
        }
    }

    private fun sendEmail(asunto:String, mensaje:String) {

        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            type = "message/rfc822" // Solo las aplicaciones de correo electrónico deben manejar esto
            putExtra(Intent.EXTRA_EMAIL, arrayOf("luciabarera4@gmail.com"))
            putExtra(Intent.EXTRA_SUBJECT, asunto)
            putExtra(Intent.EXTRA_TEXT, mensaje)
        }

        // Verificar si hay una aplicación que pueda manejar el intento
        if (emailIntent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(emailIntent, "Enviar correo con:"))
        } else {
            // Manejar el caso en el que no hay ninguna aplicación de correo electrónico instalada
            // Mostrar un mensaje al usuario o tomar otra acción apropiada
        }
    }
}
