package com.cibertec.proyectomoviles

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.io.Console

class LikesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_likes)

        val register: Button = findViewById(R.id.btnRegisterActually)
        val omitir : TextView = findViewById(R.id.btnOmitir)
        val regresar3 : ImageView = findViewById(R.id.imgRegresarDates)
        val option1: TextView = findViewById(R.id.btnOpcion1)
        val option2: TextView = findViewById(R.id.btnOpcion2)
        val option3: TextView = findViewById(R.id.btnOpcion3)
        val option4: TextView = findViewById(R.id.btnOpcion4)
        val option5: TextView = findViewById(R.id.btnOpcion5)
        val option6: TextView = findViewById(R.id.btnOpcion6)
        val option7: TextView = findViewById(R.id.btnOpcion7)
        val option8: TextView = findViewById(R.id.btnOpcion8)
        val option9: TextView = findViewById(R.id.btnOpcion9)
        val option10: TextView = findViewById(R.id.btnOpcion10)
        val option11: TextView = findViewById(R.id.btnOpcion11)
        val option12: TextView = findViewById(R.id.btnOpcion12)
        val option13: TextView = findViewById(R.id.btnOpcion13)
        val option14: TextView = findViewById(R.id.btnOpcion14)
        val option15: TextView = findViewById(R.id.btnOpcion15)
        val option16: TextView = findViewById(R.id.btnOpcion16)
        val option17: TextView = findViewById(R.id.btnOpcion17)
        val option18: TextView = findViewById(R.id.btnOpcion18)
        var interruptor1: Boolean = false
        var interruptor2: Boolean = false
        var interruptor3: Boolean = false
        var interruptor4: Boolean = false
        var interruptor5: Boolean = false
        var interruptor6: Boolean = false
        var interruptor7: Boolean = false
        var interruptor8: Boolean = false
        var interruptor9: Boolean = false
        var interruptor10: Boolean = false
        var interruptor11: Boolean = false
        var interruptor12: Boolean = false
        var interruptor13: Boolean = false
        var interruptor14: Boolean = false
        var interruptor15: Boolean = false
        var interruptor16: Boolean = false
        var interruptor17: Boolean = false
        var interruptor18: Boolean = false

        var likeOne: String? = null
        var likeTwo: String? = null
        var likeThree: String? = null
        var likeFour: String? = null
        var likeFive: String? = null

        fun cambioColorSeleccionado(textView: TextView) {
            textView.setBackgroundColor(ContextCompat.getColor(this, R.color.vino))
            textView.setTextColor(Color.rgb(255, 255, 255))
            textView.setBackgroundResource(R.drawable.disenio_boton_seleccionado)
        }

        fun cambioColorNoSeleccionado(textView: TextView) {
            textView.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            textView.setTextColor(Color.rgb(168, 0, 64))
            textView.setBackgroundResource(R.drawable.disenio_boton)
        }

        fun generarValor(valor: String) {
            if (likeOne == null ) {
                likeOne = valor
            } else if (likeTwo == null && valor != likeOne) {
                likeTwo = valor
            } else if (likeThree == null && valor != likeOne && valor != likeTwo  ) {
                likeThree = valor
            } else if (likeFour == null && valor != likeOne && valor != likeTwo && valor != likeThree ) {
                likeFour = valor
            } else if (likeFive == null && valor != likeOne && valor != likeTwo && valor != likeThree && valor != likeFour){
                likeFive = valor
            } else {
                Toast.makeText(this,"Ya has seleccionado 5 valores",Toast.LENGTH_LONG).show()
            }
        }

        fun sinValor(valor: String) {
            if (likeOne == valor) {
                likeOne = null
            } else if (likeTwo == valor && likeOne != likeTwo) {
                likeTwo = null
            } else if (likeThree == valor && valor != likeTwo && valor != likeOne) {
                likeThree = null
            } else if (likeFour == valor && valor != likeTwo && valor != likeOne) {
                likeFour = null
            } else if (likeFive == valor && valor != likeTwo && valor != likeOne){
                likeFive = null
            }else{
                Toast.makeText(this,"Ya has seleccionado 5 valores",Toast.LENGTH_LONG).show()
            }
        }

        fun bloquearOpcion(textView: TextView, interruptor: Boolean) {
            if (!interruptor) {
                textView.isClickable= false
                textView.isFocusable = false

            }
        }

        fun desbloquearOpcion(textView: TextView, interruptor: Boolean){
            if (interruptor==true || !interruptor) {
                textView.isClickable= true
                textView.isFocusable = true

            }
        }
        fun bloqueo() {
            if (likeOne != null && likeTwo != null && likeThree != null && likeFour != null
                && likeFive != null
            ) {
                bloquearOpcion(option1, interruptor1)
                bloquearOpcion(option2, interruptor2)
                bloquearOpcion(option3, interruptor3)
                bloquearOpcion(option4, interruptor4)
                bloquearOpcion(option5, interruptor5)
                bloquearOpcion(option6, interruptor6)
                bloquearOpcion(option7, interruptor7)
                bloquearOpcion(option8, interruptor8)
                bloquearOpcion(option9, interruptor9)
                bloquearOpcion(option10, interruptor10)
                bloquearOpcion(option11, interruptor11)
                bloquearOpcion(option12, interruptor12)
                bloquearOpcion(option13, interruptor13)
                bloquearOpcion(option14, interruptor14)
                bloquearOpcion(option15, interruptor15)
                bloquearOpcion(option16, interruptor16)
                bloquearOpcion(option17, interruptor17)
                bloquearOpcion(option18, interruptor18)

                Toast.makeText(this, "Selecciono 5 opciones", Toast.LENGTH_LONG).show()

            }

        }

        fun desbloquear(){
            if (likeOne == null || likeTwo == null || likeThree == null || likeFour == null
                || likeFive == null){
                desbloquearOpcion(option1,interruptor1)
                desbloquearOpcion(option2,interruptor2)
                desbloquearOpcion(option3,interruptor3)
                desbloquearOpcion(option4,interruptor4)
                desbloquearOpcion(option5,interruptor5)
                desbloquearOpcion(option6,interruptor6)
                desbloquearOpcion(option7,interruptor7)
                desbloquearOpcion(option8,interruptor8)
                desbloquearOpcion(option9,interruptor9)
                desbloquearOpcion(option10,interruptor10)
                desbloquearOpcion(option11,interruptor11)
                desbloquearOpcion(option12,interruptor12)
                desbloquearOpcion(option13,interruptor13)
                desbloquearOpcion(option14,interruptor14)
                desbloquearOpcion(option15,interruptor15)
                desbloquearOpcion(option16,interruptor16)
                desbloquearOpcion(option17,interruptor17)
                desbloquearOpcion(option18,interruptor18)

            }
        }

        option1.setOnClickListener {
            if (!interruptor1) {
                generarValor("restaurante")
                cambioColorSeleccionado(option1)
                interruptor1 = true
            } else {
                sinValor("restaurante")
                cambioColorNoSeleccionado(option1)
                interruptor1 = false
            }
            desbloquear()
            bloqueo()
        }
        option2.setOnClickListener {
            if (!interruptor2) {
                generarValor("bares")
                cambioColorSeleccionado(option2)
                interruptor2 = true
            } else {
                sinValor("bares")
                cambioColorNoSeleccionado(option2)
                interruptor2 = false
            }
            desbloquear()
            bloqueo()
        }
        option3.setOnClickListener {
            if (!interruptor3) {
                generarValor("cafeteria")
                cambioColorSeleccionado(option3)
                interruptor3 = true
            } else {
                sinValor("cafeteria")
                cambioColorNoSeleccionado(option3)
                interruptor3 = false
            }
            desbloquear()
            bloqueo()
        }
        option4.setOnClickListener {
            if (!interruptor4) {
                generarValor("criollo")
                cambioColorSeleccionado(option4)
                interruptor4 = true
            } else {
                sinValor("criollo")
                cambioColorNoSeleccionado(option4)
                interruptor4 = false
            }
            desbloquear()
            bloqueo()
        }
        option5.setOnClickListener {
            if (!interruptor5) {
                generarValor("jugueria")
                cambioColorSeleccionado(option5)
                interruptor5 = true
            } else {
                sinValor("jugueria")
                cambioColorNoSeleccionado(option5)
                interruptor5 = false
            }
            desbloquear()
            bloqueo()
        }
        option6.setOnClickListener {
            if (!interruptor6) {
                generarValor("china")
                cambioColorSeleccionado(option6)
                interruptor6 = true
            } else {
                sinValor("china")
                cambioColorNoSeleccionado(option6)
                interruptor6 = false
            }
            bloqueo()
        }
        option7.setOnClickListener {
            if (!interruptor7) {
                generarValor("mexicana")
                cambioColorSeleccionado(option7)
                interruptor7 = true
            } else {
                sinValor("mexicana")
                cambioColorNoSeleccionado(option7)
                interruptor7 = false
            }
            desbloquear()
            bloqueo()
        }
        option8.setOnClickListener {
            if (!interruptor8) {
                generarValor("italiana")
                cambioColorSeleccionado(option8)
                interruptor8 = true
            } else {
                sinValor("italiana")
                cambioColorNoSeleccionado(option8)
                interruptor8 = false
            }
            desbloquear()
            bloqueo()
        }
        option9.setOnClickListener {
            if (!interruptor9) {
                generarValor("discobar")
                cambioColorSeleccionado(option9)
                interruptor9 = true
            } else {
                sinValor("discobar")
                cambioColorNoSeleccionado(option9)
                interruptor9 = false
            }
            desbloquear()
            bloqueo()
        }
        option10.setOnClickListener {
            if (!interruptor10) {
                generarValor("pastas")
                cambioColorSeleccionado(option10)
                interruptor10 = true
            } else {
                sinValor("pastas")
                cambioColorNoSeleccionado(option10)
                interruptor10 = false
            }
            desbloquear()
            bloqueo()
        }
        option11.setOnClickListener {
            if (!interruptor11) {
                generarValor("hindu")
                cambioColorSeleccionado(option11)
                interruptor11 = true
            } else {
                sinValor("hindu")
                cambioColorNoSeleccionado(option11)
                interruptor11 = false
            }
            desbloquear()
            bloqueo()
        }
        option12.setOnClickListener {
            if (!interruptor12) {
                generarValor("tematico")
                cambioColorSeleccionado(option12)
                interruptor12 = true
            } else {
                sinValor("tematico")
                cambioColorNoSeleccionado(option12)
                interruptor12 = false
            }
            desbloquear()
            bloqueo()
        }
        option13.setOnClickListener {
            if (!interruptor13) {
                generarValor("carnes")
                cambioColorSeleccionado(option13)
                interruptor13 = true
            } else {
                sinValor("carnes")
                cambioColorNoSeleccionado(option13)
                interruptor13 = false
            }
            desbloquear()
            bloqueo()
        }
        option14.setOnClickListener {
            if (!interruptor14) {
                generarValor("buffet")
                cambioColorSeleccionado(option14)
                interruptor14 = true
            } else {
                sinValor("buffet")
                cambioColorNoSeleccionado(option14)
                interruptor14 = false
            }
            desbloquear()
            bloqueo()
        }
        option15.setOnClickListener {
            if (!interruptor15) {
                generarValor("asiatica")
                cambioColorSeleccionado(option15)
                interruptor15 = true
            } else {
                sinValor("asiatica")
                cambioColorNoSeleccionado(option15)
                interruptor15 = false
            }
            desbloquear()
            bloqueo()
        }
        option16.setOnClickListener {
            if (!interruptor16) {
                generarValor("barra libre")
                cambioColorSeleccionado(option16)
                interruptor16 = true
            } else {
                sinValor("barra libre")
                cambioColorNoSeleccionado(option16)
                interruptor16 = false
            }
            desbloquear()
            bloqueo()
        }
        option17.setOnClickListener {
            if (!interruptor17) {
                generarValor("cevicheria")
                cambioColorSeleccionado(option17)
                interruptor17 = true
            } else {
                sinValor("cevicheria")
                cambioColorNoSeleccionado(option17)
                interruptor17 = false
            }
            desbloquear()
            bloqueo()
        }
        option18.setOnClickListener {
            if (!interruptor18) {
                generarValor("japonesa")
                cambioColorSeleccionado(option18)
                interruptor18 = true
            } else {
                sinValor("japonesa")
                cambioColorNoSeleccionado(option18)
                interruptor18 = false
            }
            desbloquear()
            bloqueo()
        }



        register.setOnClickListener {
            val op1 = likeOne.toString()
            val op2 = likeTwo.toString()
            val op3 = likeThree.toString()
            val op4 = likeFour.toString()
            val op5 = likeFive.toString()

            if(likeOne == null || likeTwo == null || likeThree == null || likeFour == null || likeFive == null){
                Toast.makeText(this,"Debes seleccionar 5 opciones",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val intent = Intent(this,WelcomeActivity::class.java).apply {

            }
            startActivity(intent)
        }

        omitir.setOnClickListener {
            val intent = Intent(this,WelcomeActivity::class.java).apply{}
            startActivity(intent)
        }

        regresar3.setOnClickListener{
            val intent = Intent(this,DatesActivity::class.java).apply{}
            startActivity(intent)
        }




    }
}
