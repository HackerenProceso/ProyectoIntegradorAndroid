package com.tecsup.mitiendita.ubicacion


import android.content.Intent
import android.location.Geocoder
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.contacto.ContactoActivity
import com.tecsup.mitiendita.experiencia.ExperienciaActivity
import com.tecsup.mitiendita.home.HomeActivity
import com.tecsup.mitiendita.home.NavFragment
import com.tecsup.mitiendita.ofertas.OfertasActivity
import com.tecsup.mitiendita.reclamos.ReclamosActivity
import com.tecsup.mitiendita.reclamos.Reclamosfrm
import com.tecsup.mitiendita.sobreNosotros.SobreNosotrosActivity
import com.tecsup.mitiendita.terminos.TerminosActivity
import java.util.Locale

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ubicacion)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<NavFragment>(R.id.fragmentNav)
            }
        }

        val btnRegresarU = findViewById<Button>(R.id.btnRegresarU)
        btnRegresarU.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.uiSettings.isZoomControlsEnabled = true
        map.uiSettings.isRotateGesturesEnabled = false

        val markerPlace = LatLng(-8.147374, -79.041725)

        // Añadir marcador

        map.addMarker(
            MarkerOptions()
                .position(markerPlace)
                .title("Mi Tiendita")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        )

        // Animar la cámara
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(markerPlace, 15f)
        )

        // Ejemplo de obtener la dirección
        map.setOnMapClickListener { latLng ->
            map.clear()
            map.addMarker(MarkerOptions().position(latLng).title("Nuevo Marcador"))

            // Aquí podrías obtener la dirección utilizando Geocoder si lo deseas
            getStreetName(latLng.latitude, latLng.longitude)
        }
    }

    private fun getStreetName(latitude: Double, longitude: Double) {
        val geocoder = Geocoder(this, Locale.getDefault())
        try {
            val addresses = geocoder.getFromLocation(latitude, longitude, 1)
            if (addresses != null) {
                if (addresses.isNotEmpty()) {
                    val address = addresses[0]
                    val streetName = address.getAddressLine(0)
                    Toast.makeText(this, streetName, Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
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
