package com.tecsup.mitiendita

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.tecsup.mitiendita.api.SharedPreference
import com.tecsup.mitiendita.welcome.WelcomeTutorial
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        val actionBar = supportActionBar
        actionBar?.hide()


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, WelcomeTutorial::class.java)
            SharedPreference().clearSharedPreferences(this)
            startActivity(intent)
            finish() //
        }, 2000) // Retraso de 2 segundos
    }

}