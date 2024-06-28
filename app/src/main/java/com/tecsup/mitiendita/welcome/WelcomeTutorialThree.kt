package com.tecsup.mitiendita.welcome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.home.HomeActivity

class WelcomeTutorialThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_tutorial_three)

        val actionBar = supportActionBar
        actionBar?.hide()

        val guideEndButton = findViewById<FloatingActionButton>(R.id.GuideEnd)
        guideEndButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}