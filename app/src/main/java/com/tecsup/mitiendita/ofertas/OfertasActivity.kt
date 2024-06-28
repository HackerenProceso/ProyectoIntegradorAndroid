package com.tecsup.mitiendita.ofertas

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.cupones.CuponFragment
import com.tecsup.mitiendita.home.NavFragment

class OfertasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ofertas_categorias)


        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FragmentOfertas>(R.id.fragmenOfertas)
            }
        }
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<NavFragment>(R.id.fragmentNav)
            }
        }

        val btn1 = findViewById<Button>(R.id.button1)
        val btn2 = findViewById<Button>(R.id.button2)

        btn1.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.fragmenOfertas, FragmentOfertas()).commit()
        }

        btn2.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmenOfertas, CuponFragment()).commit()
        }

    }

}
