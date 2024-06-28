package com.tecsup.mitiendita.access

import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.tecsup.mitiendita.R

class PasswordRecoveryActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_recovery)

        val actionBar = supportActionBar
        actionBar?.hide()

        auth = FirebaseAuth.getInstance()

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val checkboxAccept = findViewById<CheckBox>(R.id.checkboxAccept)
        val btnRecoveryPassword = findViewById<MaterialButton>(R.id.btnRecoveryPassword)

        btnRecoveryPassword.setOnClickListener {
            val email = etEmail.text.toString().trim() // Eliminar espacios en blanco
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(
                    this,
                    "Por favor, ingrese su correo electrónico.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            if (password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(
                    this,
                    "Por favor, ingrese y confirme su nueva contraseña.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!checkboxAccept.isChecked) {
                Toast.makeText(this, "Debe aceptar los términos y condiciones.", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            // Actualizar la contraseña directamente en Firebase Authentication

            val user = auth.currentUser
            if (user != null) {
                user.updatePassword(password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) { // Actualización exitosa
                            Toast.makeText(
                                this,
                                "Contraseña actualizada con éxito.",
                                Toast.LENGTH_SHORT
                            ).show()
                            finish() // Cerrar la actividad
                        } else {
                            // Manejar errores específicos de Firebase Authentication
                            when (task.exception) {
                                is FirebaseAuthInvalidCredentialsException -> {
                                    Toast.makeText(
                                        this,
                                        "Credenciales inválidas. La contraseña debe tener al menos 6 caracteres.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                is FirebaseAuthInvalidUserException -> {
                                    Toast.makeText(
                                        this,
                                        "Usuario no válido. Por favor, inicie sesión nuevamente.",
                                        Toast.LENGTH_SHORT
                                    ).show() // Cerrar la sesión
                                }

                                else -> {
                                    Toast.makeText(
                                        this,
                                        "Error al actualizar la contraseña. Inténtelo de nuevo más tarde.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    }
            } else {
                Toast.makeText(
                    this,
                    "No se encontró usuario. Inicie sesión nuevamente.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
