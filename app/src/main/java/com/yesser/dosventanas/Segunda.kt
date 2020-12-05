package com.yesser.dosventanas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Segunda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        val cadena:String = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_KEY);

        val texto:TextView = findViewById(R.id.idTextoRecibido)
        texto.text = "$cadena"

        val boton:Button = findViewById(R.id.btRegresar)
        boton.setOnClickListener{
            val etRespuesta:EditText = findViewById(R.id.etRespuesta)
            val respuesta:String = etRespuesta.text.toString()
            val intentRespuesta = intent
            intentRespuesta.putExtra("EXTRA",respuesta)
            setResult(RESULT_OK,intentRespuesta)
            finish()
        }
    }
}