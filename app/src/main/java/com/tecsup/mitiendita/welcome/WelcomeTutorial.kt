package com.tecsup.mitiendita.welcome

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tecsup.mitiendita.R

class WelcomeTutorial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_tutorial)

        val actionBar = supportActionBar
        actionBar?.hide()

        val guideTwoButton = findViewById<FloatingActionButton>(R.id.GuideTwo)
        guideTwoButton.setOnClickListener {
            val intent = Intent(this, WelcomeTutorialTwo::class.java)
            startActivity(intent)
            finish()
        }
    }
}