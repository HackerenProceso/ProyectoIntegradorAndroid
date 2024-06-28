package com.tecsup.mitiendita.access

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.home.HomeActivity

class LoginActivity : AppCompatActivity() {

    //Declaración de la variable de autenticación Firebase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val actionBar = supportActionBar
        actionBar?.hide()


        auth = FirebaseAuth.getInstance()

        //Obtención de los elementos de la interfaz de usuario
        val etEmail = findViewById<EditText>(R.id.etEmail) //editar el texto
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)


        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()//eliminar espacios
            val password = etPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) { //si los campos están vacíos
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(email, password) //autenticar el usuario
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) { //si la autenticación es exitosa
                        val intent = Intent(this, ConfirmationLoginRegisterActivity::class.java)
                        intent.putExtra("login", getString(R.string.success_login))
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Error en el inicio de sesión: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        val btnRecoveryPassword = findViewById<Button>(R.id.btnRecoveryPassword)
        btnRecoveryPassword.setOnClickListener {
            val intent = Intent(this, PasswordRecoveryActivity::class.java)
            startActivity(intent)
        }
    }
}
