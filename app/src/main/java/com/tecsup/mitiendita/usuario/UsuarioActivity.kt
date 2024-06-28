package com.tecsup.mitiendita.usuario


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.tecsup.mitiendita.R
import com.tecsup.mitiendita.home.HomeActivity
import com.tecsup.mitiendita.home.NavFragment
import java.io.File
import java.io.FileOutputStream

class UsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<NavFragment>(R.id.fragmentNav)
            }
        }

        // Obtener referencias a los ImageView
        val check01: ImageView = findViewById(R.id.check01)
        val check02: ImageView = findViewById(R.id.check02)
        val check03: ImageView = findViewById(R.id.check03)
        val check04: ImageView = findViewById(R.id.check04)
        val btnRegresar: Button = findViewById(R.id.btnRegresarU)

        // Configuramos cada flechita para reedirigirlo a sua ctividad correspondiente
        check01.setOnClickListener {
            val intent = Intent(this, DatosUsuarioActivity::class.java)
            startActivity(intent)
        }

        check02.setOnClickListener {
            val intent = Intent(this, ComprasActivity::class.java)
            startActivity(intent)
        }

        check03.setOnClickListener {
            val intent = Intent(this, CuponesUsuario::class.java)
            startActivity(intent)
        }
        check04.setOnClickListener {

            val nombreArchivo = "catalogos.docx"

            // Archivo destino en la carpeta files de la aplicación
            val file = File(filesDir, nombreArchivo)

            // Si el archivo no existe en la carpeta files, copiarlo desde assets
            if (!file.exists()) {
                copyFileFromAssetsToFiles(nombreArchivo)
            }

            // Abrir el archivo
            abrirDocumento(file)
        }
        btnRegresar.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun copyFileFromAssetsToFiles(fileName: String) {
        try {
            val inputStream = assets.open(fileName)
            val outputFile = File(filesDir, fileName)
            val outputStream = FileOutputStream(outputFile)
            inputStream.copyTo(outputStream)
            outputStream.close()
            inputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun abrirDocumento(file: File) {
        try {
            val uri: Uri = FileProvider.getUriForFile(this, "${packageName}.fileprovider", file)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(uri, "application/pdf")
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_GRANT_READ_URI_PERMISSION
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
