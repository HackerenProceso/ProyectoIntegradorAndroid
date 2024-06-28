package com.tecsup.mitiendita.carrito

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.home.HomeActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PagoRealizado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_realizado)

        lifecycleScope.launch {
            delay(3000)
            createNotificationChannel()
            showNotification()
            startActivity(Intent(this@PagoRealizado, HomeActivity::class.java))}

    }

    private fun createNotificationChannel() {
        val name = "MyNotificationChannel"
        val descriptionText = "This is a notification channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel("CHANNEL_ID", name, importance).apply {
            description = descriptionText
        }
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }


    private fun showNotification() {
        val builder = NotificationCompat.Builder(this, "CHANNEL_ID")
            .setSmallIcon(R.drawable.logo_background) // Reemplazar con tu propio icono
            .setContentTitle("Pago Realizado!")
            .setContentText("Gracias por su compra!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            // notificationId es un ID único para cada notificación que quieras mostrar
            if (ActivityCompat.checkSelfPermission(
                    this@PagoRealizado,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            notify(1, builder.build())
        }
    }
}