package com.tecsup.mitiendita.carrito

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.gson.Gson
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.api.productos
import org.json.JSONException
import java.math.BigDecimal

class CarritoActivity : AppCompatActivity() {

    private lateinit var adapter: AdaptadorCarrito
    private var carroCompras = ArrayList<productos>()


    /*companion object {
        private const val PAYPAL_REQUEST_CODE = 123
        private val config = PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX) // Cambiar a ENVIRONMENT_PRODUCTION en producción
            .clientId("AcrIlSxOZ93MzwOjCI0KHjtnp8i5vghz1daxMtRbG6Ir2X0VnXAGFKaKmoZBhxWn94l-dE6inQcPcDVf") // Reemplazar con tu Client ID de PayPal
    }*/

    /*override fun onNewIntent(newIntent: Intent?) {
        super.onNewIntent(intent)
        intent = newIntent
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)

        val btnPagar = findViewById<MaterialButton>(R.id.btnPagar)
        btnPagar.setOnClickListener {
            Log.d("CarritoActivity", "Botón Pagar presionado")
            startActivity(Intent(this, PagoRealizado::class.java))
            //processPayment()
        }


        val sp = getSharedPreferences("carrito", Context.MODE_PRIVATE)
        val jsonString = sp.getString("productos", "")
        val gson = Gson()
        carroCompras = gson.fromJson(jsonString, Array<productos>::class.java).toCollection(ArrayList())

        initRecyclerView()
    }

    /*override fun onDestroy() {
        stopService(Intent(this, PayPalService::class.java))
        super.onDestroy()
    }*/

    private fun initRecyclerView() {
        val rvListaCarro = findViewById<RecyclerView>(R.id.rvListaCarro)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)
        rvListaCarro.layoutManager = LinearLayoutManager(this)
        adapter = AdaptadorCarrito(tvTotal, carroCompras)
        rvListaCarro.adapter = adapter
    }

    /*private fun processPayment() {
        val tvTotal = findViewById<TextView>(R.id.tvTotal)
        val amount = tvTotal.text.toString()
        val payment = PayPalPayment(
            BigDecimal(amount),
            "PEN", // Cambiar a la moneda correspondiente
            "Compra en Mi Tiendita",
            PayPalPayment.PAYMENT_INTENT_SALE
        )

        val intent = Intent(this, PaymentActivity::class.java)
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config)
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment)
        startActivityForResult(intent, PAYPAL_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PAYPAL_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                val confirm = data?.getParcelableExtra<PaymentConfirmation>(PaymentActivity.EXTRA_RESULT_CONFIRMATION)
                if (confirm != null) {
                    try {
                        val details = confirm.toJSONObject().toString(4)
                        // Aquí puedes enviar los detalles del pago a tu servidor para verificarlo
                        showNotification()
                        startActivity(Intent(this, PagoRealizado::class.java))
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            } else if (resultCode == RESULT_CANCELED) {
                // El usuario canceló el pago
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                // Los detalles del pago eran inválidos
            }
        }
    }*/
}
