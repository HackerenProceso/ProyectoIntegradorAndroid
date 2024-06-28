package com.tecsup.mitiendita.welcome


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.tecsup.mitiendita.access.LoginActivity
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.access.RegisterActivity
import com.tecsup.mitiendita.home.HomeActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama al método onCreate de la clase base (AppCompatActivity)
        setContentView(R.layout.activity_main) // Establece el layout activity_main como la vista para esta actividad

        val actionBar = supportActionBar  //Obtiene la referencia a la ActionBar de la actividad
        actionBar?.hide() // Oculta la ActionBar si está presente

        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val btnRegister = findViewById<MaterialButton>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}


