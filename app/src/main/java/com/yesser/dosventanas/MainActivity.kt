package com.yesser.dosventanas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object EXTRA{
        val EXTRA_MESSAGE_KEY:String = "com.example.android.dosventanas.MESSAGE"
        val REQUEST_CODE:Int = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun lanzarSegundaPantalla(view: View) {
        val etNombre:EditText = findViewById(R.id.etPersonName)
        val mensaje:String = etNombre.text.toString()
        val intent:Intent = Intent(this,Segunda::class.java)
        intent.putExtra(EXTRA_MESSAGE_KEY,mensaje)
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE)
        {
            if (resultCode == RESULT_OK)
            {
                val cadenaObtenida:String = data!!.getStringExtra("EXTRA")
                val texto:TextView = findViewById(R.id.textView)
                texto.text = "$cadenaObtenida"
            }
        }
    }

}