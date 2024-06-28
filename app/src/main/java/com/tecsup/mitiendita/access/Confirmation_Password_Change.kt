package com.tecsup.mitiendita.access



import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.home.HomeActivity

class Confirmation_Password_Change : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation_password_change)

        val actionBar = supportActionBar
        actionBar?.hide()

        val btnRecoveryPasswordLogin = findViewById<MaterialButton>(R.id.btnRecoveryPasswordLogin)
        btnRecoveryPasswordLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
