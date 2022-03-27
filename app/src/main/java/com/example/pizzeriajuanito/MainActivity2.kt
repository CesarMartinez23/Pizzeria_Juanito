package com.example.pizzeriajuanito

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val NombreCliente = findViewById<TextView>(R.id.textView_clientName)
        val ProductoSeleccionado = findViewById<TextView>(R.id.textView_productSelected)
        val RegresarActividad = findViewById<Button>(R.id.button_back_order)
        val DatosMainActivity : Intent = intent
        var ClientName = DatosMainActivity.getStringExtra("Nombre")
        var TotalCompra = DatosMainActivity.getIntExtra("Total",0)
        var Ingredients = DatosMainActivity.getStringExtra("Ingredientes")

        NombreCliente.text = "Estimado Cliente: $ClientName"
        ProductoSeleccionado.text = "Su producto seleccionado es una pizza de: $Ingredients.\n" +
                "\n" + "El precio total de la compra es de: $ $TotalCompra dolares"

        RegresarActividad.setOnClickListener {
            var regresarOrden : Intent = Intent(this,MainActivity::class.java)
            startActivity(regresarOrden)
        }

    }
}