package com.tecsup.mitiendita.welcome

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tecsup.mitiendita.R

class WelcomeTutorialTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_tutorial_two)

        val actionBar = supportActionBar
        actionBar?.hide()

        val guideThreeButton = findViewById<FloatingActionButton>(R.id.GuideThree)
        guideThreeButton.setOnClickListener {
            val intent = Intent(this, WelcomeTutorialThree::class.java)
            startActivity(intent)
            finish()
        }
    }
}