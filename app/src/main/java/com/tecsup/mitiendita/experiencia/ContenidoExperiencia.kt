package com.tecsup.mitiendita.experiencia

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.home.NavFragment

class ContenidoExperiencia : AppCompatActivity() {

    // Aqui es el resumen de la calificación y el comentario los cuales son pasados a través de un Intent, esto llevara los datos al gmail

    private lateinit var textoCalificacion: TextView
    private lateinit var comentarioCalificacion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contenido_experiencia)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<NavFragment>(R.id.fragmentNav)
            }
        }

        textoCalificacion = findViewById(R.id.textoCalificacion)
        comentarioCalificacion = findViewById(R.id.comentarioCalificacion)

        val titulo = intent.getFloatExtra("RATING", 0f)
        val comentario = intent.getStringExtra("COMMENT")

        textoCalificacion.text = "Calificación: $titulo"
        comentarioCalificacion.text = "Comentario: $comentario"
    }

}
