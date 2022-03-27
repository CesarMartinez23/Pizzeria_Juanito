package com.example.pizzeriajuanito

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

var money = 0

var total = 0

var sizePizza = ""
var ingredientsPizza = ""


@SuppressLint("StaticFieldLeak")
var editText_person_name : EditText? = null
//Radio Group

@SuppressLint("StaticFieldLeak")
var radioGroup : RadioGroup? = null
//Radio Buttons
@SuppressLint("StaticFieldLeak")
var radioButton_small_pizza : RadioButton? =null
@SuppressLint("StaticFieldLeak")
var radioButton_medium_pizza : RadioButton? = null
@SuppressLint("StaticFieldLeak")
var radioButton_big_pizza : RadioButton? = null

//CheckBox
@SuppressLint("StaticFieldLeak")
var checkBox_Meat : CheckBox? = null
@SuppressLint("StaticFieldLeak")
var checkBox_Ham : CheckBox? = null
@SuppressLint("StaticFieldLeak")
var checkBox_Pepperoni : CheckBox? = null
@SuppressLint("StaticFieldLeak")
var checkBox_Three_Cheeses : CheckBox? = null
@SuppressLint("StaticFieldLeak")
var checkBox_Mushrooms : CheckBox? = null
@SuppressLint("StaticFieldLeak")
var checkBox_Vegetables : CheckBox? = null
@SuppressLint("StaticFieldLeak")
var checkBox_Pineapple : CheckBox? = null
@SuppressLint("StaticFieldLeak")
var checkBox_Olives : CheckBox? = null
@SuppressLint("StaticFieldLeak")
var checkBox_Jalapeno : CheckBox? = null

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Person Name
        editText_person_name = findViewById(R.id.editText_person_name)

        // Radio Group
        radioGroup = findViewById(R.id.radioGroup)

        //Radios Button
        radioButton_small_pizza = findViewById(R.id.radioButton_small_pizza)
        radioButton_medium_pizza = findViewById(R.id.radioButton_medium_pizza)
        radioButton_big_pizza = findViewById(R.id.radioButton_big_pizza)

        //CheckBox
        checkBox_Meat = findViewById(R.id.checkBox_Meat)
        checkBox_Ham = findViewById(R.id.checkBox_Ham)
        checkBox_Pepperoni = findViewById(R.id.checkBox_Pepperoni)
        checkBox_Three_Cheeses = findViewById(R.id.checkBox_Three_Cheeses)
        checkBox_Mushrooms = findViewById(R.id.checkBox_Mushrooms)
        checkBox_Vegetables = findViewById(R.id.checkBox_Vegetables)
        checkBox_Pineapple = findViewById(R.id.checkBox_Pineapple)
        checkBox_Olives = findViewById(R.id.checkBox_Olives)
        checkBox_Jalapeno = findViewById(R.id.checkBox_Jalapeno)
        val button_send_information = findViewById<Button>(R.id.button_send_information)

        radioButton_small_pizza?.setOnClickListener {
            visibilityCheckBoxSmallPizza()
            sizePizza = "Pizza Pequeña"
            money=4
        }
        radioButton_medium_pizza?.setOnClickListener {
            visibilityCheckBoxSmallPizza()
            sizePizza = "Pizza Mediana"
            money=6
        }
        radioButton_big_pizza?.setOnClickListener{
            visibilityCheckBoxSmallPizza()
            sizePizza = "Pizza Grande"
            money=8
        }

        button_send_information.setOnClickListener {
            checkboxSelected()
            when(money){
                4 -> {
                    if (total <= money){
                        Toast.makeText(this,"Compra realizada $ $total ",Toast.LENGTH_LONG).show()
                        total = 0
                        var intent : Intent = Intent(this,MainActivity2::class.java)
                        val NombreCliente = editText_person_name?.text.toString()
                        intent.putExtra("Nombre",NombreCliente)
                        intent.putExtra("Total",money)
                        intent.putExtra("Ingredientes", ingredientsPizza)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"Ha Excedido $ ${total-money}",Toast.LENGTH_LONG).show()
                        total = 0
                        ingredientsPizza = ""
                    }
                }
                6 -> {
                    if (total <= money){
                        Toast.makeText(this,"Compra realizada $ $total ",Toast.LENGTH_LONG).show()
                        total = 0
                        var intent : Intent = Intent(this,MainActivity2::class.java)
                        val NombreCliente = editText_person_name?.text.toString()
                        intent.putExtra("Nombre",NombreCliente)
                        intent.putExtra("Total",money)
                        intent.putExtra("Ingredientes", ingredientsPizza)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"Ha Excedido $ ${total-money}",Toast.LENGTH_LONG).show()
                        total = 0
                        ingredientsPizza = ""
                    }
                }
                8 -> {
                    if (total <= money){
                        Toast.makeText(this,"Compra realizada $ $total ",Toast.LENGTH_LONG).show()
                        total = 0
                        var intent : Intent = Intent(this,MainActivity2::class.java)
                        val NombreCliente = editText_person_name?.text.toString()
                        intent.putExtra("Nombre",NombreCliente)
                        intent.putExtra("Total",money)
                        intent.putExtra("Ingredientes", ingredientsPizza)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"Ha Excedido $ ${total-money}",Toast.LENGTH_LONG).show()
                        total = 0
                        ingredientsPizza = ""
                    }
                }
            }
        }
    }

    fun visibilityCheckBoxSmallPizza(){
        if (radioButton_small_pizza?.isChecked == true){
            checkBox_Mushrooms?.visibility = View.INVISIBLE
            checkBox_Vegetables?.visibility = View.INVISIBLE
            checkBox_Pineapple?.visibility = View.INVISIBLE
            checkBox_Olives?.visibility = View.INVISIBLE
            checkBox_Jalapeno?.visibility = View.INVISIBLE
        } else if (radioButton_medium_pizza?.isChecked == true || radioButton_big_pizza?.isChecked == true ){
            checkBox_Mushrooms?.visibility = View.VISIBLE
            checkBox_Vegetables?.visibility = View.VISIBLE
            checkBox_Pineapple?.visibility = View.VISIBLE
            checkBox_Olives?.visibility = View.VISIBLE
            checkBox_Jalapeno?.visibility = View.VISIBLE
        }
    }

    fun checkboxSelected(){
        if (checkBox_Meat?.isChecked == true) {
            ingredientsPizza += " Carne,"
            total += 4
        }
        if (checkBox_Ham?.isChecked == true) {
            ingredientsPizza += " Jamon,"
            total += 4
        }
        if (checkBox_Pepperoni?.isChecked == true) {
            ingredientsPizza += " Pepperoni,"
            total += 4
        }
        if (checkBox_Three_Cheeses?.isChecked == true) {
            ingredientsPizza += " 3 Quesos,"
            total += 4
        }

        if (checkBox_Mushrooms?.isChecked == true) {
            ingredientsPizza += " ,Hongos"
            total += 1
        }
        if (checkBox_Vegetables?.isChecked == true) {
            ingredientsPizza += " ,Vegetales"
            total += 1
        }
        if (checkBox_Pineapple?.isChecked == true) {
            ingredientsPizza += " ,Piña"
            total += 1
        }
        if (checkBox_Olives?.isChecked == true) {
            ingredientsPizza += " ,Aceitunas"
            total += 1
        }
        if (checkBox_Jalapeno?.isChecked == true) {
            ingredientsPizza += " ,Jalapeño"
            total += 1
        }
    }
}
