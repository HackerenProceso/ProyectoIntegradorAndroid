package com.tecsup.mitiendita.access

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.tecsup.mitiendita.home.HomeActivity
import com.tecsup.mitiendita.R

class ConfirmationLoginRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation_login_register)

        val actionBar = supportActionBar
        actionBar?.hide()

        val intent = intent
        var titulo = intent.getStringExtra("login")
        var tituloregister = intent.getStringExtra("register")
        val txtContenido = findViewById<TextView>(R.id.txtContenido)
        txtContenido.text = titulo ?: tituloregister

        val btnHome = findViewById<MaterialButton>(R.id.btnHome)
        btnHome.setOnClickListener {
                val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}