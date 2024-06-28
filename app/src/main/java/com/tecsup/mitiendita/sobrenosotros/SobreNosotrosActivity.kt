package com.tecsup.mitiendita.sobreNosotros


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager

import androidx.recyclerview.widget.RecyclerView

import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.contacto.ContactoActivity
import com.tecsup.mitiendita.experiencia.ExperienciaActivity
import com.tecsup.mitiendita.home.HomeActivity
import com.tecsup.mitiendita.home.NavFragment
import com.tecsup.mitiendita.nosotros.Nosotros
import com.tecsup.mitiendita.ofertas.OfertasActivity
import com.tecsup.mitiendita.reclamos.ReclamosActivity
import com.tecsup.mitiendita.terminos.TerminosActivity
import com.tecsup.mitiendita.ubicacion.MapActivity
import com.tecsup.tecsupapp.notas.SobreNosotrosAdapter

class SobreNosotrosActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobrenosotros)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<NavFragment>(R.id.fragmentNav)
            }
        }

        val recyclerViewNosotros = findViewById<RecyclerView>(R.id.recyclerViewNosotros)

        val listNosotros = listOf(
            Nosotros("Aprovecha nuestro servicio de entrega gratuita en Trujillo con Mi Tiendita! Somos tu mejor opción para compras en línea en la ciudad. Llevamos lo que necesitas directamente a tu ubicación, bebidas, productos de despensa y mucho más. ¡Bienvenido a Mi Tiendita, tu tienda de abarrotes en línea!","Nuestra Mision"),
            Nosotros("En Mi Tiendita, nos comprometemos a proporcionar a nuestros clientes la conveniencia de realizar compras en línea y recibir sus productos de forma rápida y segura en la ciudad de Trujillo. Nos esforzamos por ofrecer un servicio de entrega confiable, una amplia gama de productos y una experiencia de compra sin complicaciones.\n","Nuestra Historia"),
            Nosotros("Desde nuestros inicios, hemos estado comprometidos con la satisfacción del cliente y la excelencia en el servicio. Fundada en Trujillo \"Mi tiendita\" ha crecido para convertirse en una de las principales tiendas de conveniencia de la ciudad, ofreciendo una selección diversa de productos para satisfacer las necesidades de nuestros clientes.\n", "Nuestro Valores"),
            Nosotros(" En Mi Tiendita, nos regimos por principios fundamentales que nos orientan a mantener altos estándares en todas nuestras operaciones:\n" + "\n" + "Compromiso con la Calidad: Nos esforzamos por proporcionar productos de alta calidad y servicios confiables a nuestros clientes.\n" + "\n" + "Integridad: Operamos de manera ética y transparente en todas nuestras actividades comerciales, manteniendo la confianza de nuestros clientes y socios.\n" + "\n" + "Innovación: Buscamos constantemente nuevas formas de mejorar y adaptarnos a las necesidades cambiantes de nuestros clientes, aprovechando la tecnología para ofrecer una experiencia de compra superior.\n" + "\n" + "\n" + "\n" + "\n","Nuestro Equipo"),
            Nosotros("Detrás de cada entrega y cada pedido, hay un equipo dedicado de profesionales comprometidos con su satisfacción. Desde nuestros repartidores hasta nuestro equipo de atención al cliente, cada miembro de nuestro equipo trabaja arduamente para garantizar que su experiencia con \"Mi Tiendita\" sea excepcional en todo momento.","Contactanos")
        )

        val adapter = SobreNosotrosAdapter(listNosotros)
        recyclerViewNosotros.adapter = adapter
        recyclerViewNosotros.layoutManager = GridLayoutManager(this, 1)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal_02, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemInicio -> {
                startActivity(Intent(this, HomeActivity::class.java))
                return true
            }
            R.id.itemNosotros -> {
                startActivity(Intent(this, SobreNosotrosActivity::class.java))
                return true
            }
            R.id.itemOfertas -> {
                startActivity(Intent(this, OfertasActivity::class.java))
                return true
            }
            R.id.itemUbicacion -> {
                startActivity(Intent(this, MapActivity::class.java))
                return true
            }
            R.id.itemContacto -> {
                startActivity(Intent(this, ContactoActivity::class.java))
                return true
            }
            R.id.itemReclamo -> {
                startActivity(Intent(this, ReclamosActivity::class.java))
                return true
            }
            R.id.itemTerminos -> {
                startActivity(Intent(this, TerminosActivity::class.java))
                return true
            }
            R.id.itemExperiencia -> {
                startActivity(Intent(this, ExperienciaActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

