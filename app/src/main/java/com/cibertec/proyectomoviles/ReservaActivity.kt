package com.cibertec.proyectomoviles

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.cibertec.proyectomoviles.databinding.ActivityPerfilRestauranteBinding
import com.cibertec.proyectomoviles.databinding.ActivityReservaBinding

class ReservaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReservaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val option1 : TextView = findViewById(R.id.txtHorarioUno)
        val option2 : TextView = findViewById(R.id.txtHorarioDos)
        val option3 : TextView = findViewById(R.id.txtHorarioTres)
        val option4 : TextView = findViewById(R.id.txtHorarioCuatro)
        val option5 : TextView = findViewById(R.id.txtHorarioCinco)
        val option6 : TextView = findViewById(R.id.txtHorarioSeis)
        val option7 : TextView = findViewById(R.id.txtHorarioSiete)
        val option8 : TextView = findViewById(R.id.txtHorarioOcho)
        val option9 : TextView = findViewById(R.id.txtHorarioNueve)
        val option10 : TextView = findViewById(R.id.txtHorarioDiez)
        val option11 : TextView = findViewById(R.id.txtHorarioOnce)
        val option12 : TextView = findViewById(R.id.txtHorarioDoce)

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

        var horario : String? = null

        val bundle = intent.extras
        var codigo =0

        bundle?.let {
            codigo = it.getInt("KEY_ID")
        }

        fun cambioColorSeleccionado(textView: TextView) {
            textView.setBackgroundColor(ContextCompat.getColor(this, R.color.vino))
            textView.setTextColor(Color.rgb(255, 255, 255))
            textView.setBackgroundResource(R.drawable.disenio_boton_seleccionado)
        }

        fun cambioColorNoSeleccionado(textView: TextView) {
            textView.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            textView.setTextColor(Color.rgb(112, 108, 108))
            textView.setBackgroundResource(R.drawable.disenio_boton_reserved)
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

        fun generarValor(valor: String) {
            if (horario == null ) {
                horario = valor
            } else {
                Toast.makeText(this,"Ya has seleccionado un horario", Toast.LENGTH_LONG).show()
            }
        }

        fun sinValor(valor: String) {
            if (horario == valor) {
                horario = null
            }else{
                Toast.makeText(this,"Ya has seleccionado un valor",Toast.LENGTH_LONG).show()
            }
        }

        fun bloqueo() {
            if (horario != null) {
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

                Toast.makeText(this, "Ya selecciono un horario", Toast.LENGTH_LONG).show()

            }

        }

        fun desbloquear(){
            if (horario == null ){
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

            }
        }

        option1.setOnClickListener {
            if (!interruptor1) {
                generarValor("17:00")
                cambioColorSeleccionado(option1)
                interruptor1 = true
            } else {
                sinValor("17:00")
                cambioColorNoSeleccionado(option1)
                interruptor1 = false
            }
            desbloquear()
            bloqueo()
        }
        option2.setOnClickListener {
            if (!interruptor2) {
                generarValor("17:30")
                cambioColorSeleccionado(option2)
                interruptor2 = true
            } else {
                sinValor("17:30")
                cambioColorNoSeleccionado(option2)
                interruptor2 = false
            }
            desbloquear()
            bloqueo()
        }
        option3.setOnClickListener {
            if (!interruptor3) {
                generarValor("18:00")
                cambioColorSeleccionado(option3)
                interruptor3 = true
            } else {
                sinValor("18:00")
                cambioColorNoSeleccionado(option3)
                interruptor3 = false
            }
            desbloquear()
            bloqueo()
        }
        option4.setOnClickListener {
            if (!interruptor4) {
                generarValor("18:30")
                cambioColorSeleccionado(option4)
                interruptor4 = true
            } else {
                sinValor("18:30")
                cambioColorNoSeleccionado(option4)
                interruptor4 = false
            }
            desbloquear()
            bloqueo()
        }
        option5.setOnClickListener {
            if (!interruptor5) {
                generarValor("19:00")
                cambioColorSeleccionado(option5)
                interruptor5 = true
            } else {
                sinValor("19:00")
                cambioColorNoSeleccionado(option5)
                interruptor5 = false
            }
            desbloquear()
            bloqueo()
        }
        option6.setOnClickListener {
            if (!interruptor6) {
                generarValor("19:30")
                cambioColorSeleccionado(option6)
                interruptor6 = true
            } else {
                sinValor("19:30")
                cambioColorNoSeleccionado(option6)
                interruptor6 = false
            }
            desbloquear()
            bloqueo()
        }
        option7.setOnClickListener {
            if (!interruptor7) {
                generarValor("20:00")
                cambioColorSeleccionado(option7)
                interruptor7 = true
            } else {
                sinValor("20:00")
                cambioColorNoSeleccionado(option7)
                interruptor7 = false
            }
            desbloquear()
            bloqueo()
        }
        option8.setOnClickListener {
            if (!interruptor8) {
                generarValor("20:30")
                cambioColorSeleccionado(option8)
                interruptor8 = true
            } else {
                sinValor("20:30")
                cambioColorNoSeleccionado(option8)
                interruptor8 = false
            }
            desbloquear()
            bloqueo()
        }
        option9.setOnClickListener {
            if (!interruptor9) {
                generarValor("21:00")
                cambioColorSeleccionado(option9)
                interruptor9 = true
            } else {
                sinValor("21:00")
                cambioColorNoSeleccionado(option9)
                interruptor9 = false
            }
            desbloquear()
            bloqueo()
        }
        option10.setOnClickListener {
            if (!interruptor10) {
                generarValor("21:30")
                cambioColorSeleccionado(option10)
                interruptor10 = true
            } else {
                sinValor("21:30")
                cambioColorNoSeleccionado(option10)
                interruptor10 = false
            }
            desbloquear()
            bloqueo()
        }
        option11.setOnClickListener {
            if (!interruptor11) {
                generarValor("22:00")
                cambioColorSeleccionado(option11)
                interruptor11 = true
            } else {
                sinValor("22:00")
                cambioColorNoSeleccionado(option11)
                interruptor11 = false
            }
            desbloquear()
            bloqueo()
        }
        option12.setOnClickListener {
            if (!interruptor12) {
                generarValor("22:30")
                cambioColorSeleccionado(option12)
                interruptor12 = true
            } else {
                sinValor("22:30")
                cambioColorNoSeleccionado(option12)
                interruptor12 = false
            }
            desbloquear()
            bloqueo()
        }



    }
}