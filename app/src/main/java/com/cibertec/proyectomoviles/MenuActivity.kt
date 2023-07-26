package com.cibertec.proyectomoviles

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val home: TextView = findViewById(R.id.btnMenu)
        val busqueda: TextView = findViewById(R.id.btnSearch)
        val reserva: TextView = findViewById(R.id.btnBoonkings)
        val perfil: TextView = findViewById(R.id.btnProfile)
        val nColor = ContextCompat.getColor(this, R.color.vino)
        val iconHome = home.compoundDrawables


        fun seleccion(textView: TextView) {

            val colorSeleccion = ContextCompat.getColor(this,R.color.vino)
            val textoSeleccion = Color.rgb(255,255,255)
            val colorDefault = ContextCompat.getColor(this,R.color.menu)
            val textoDefault = Color.parseColor("#757575BD")

            home.setBackgroundColor(if (textView == home) colorSeleccion else colorDefault)
            home.setTextColor(if(textView == home )textoSeleccion else textoDefault)
            val newHome =
                if (textView == home) R.drawable.baseline_home_white else R.drawable.baseline_home_black
            home.setCompoundDrawablesWithIntrinsicBounds(
                null,
                ContextCompat.getDrawable(this, newHome),
                null,
                null
            )

            busqueda.setBackgroundColor(if (textView == busqueda) colorSeleccion else colorDefault)
            busqueda.setTextColor(if(textView == busqueda )textoSeleccion else textoDefault)
            val newSearch =
                if (textView == busqueda) R.drawable.baseline_search_white else R.drawable.baseline_search_black
            busqueda.setCompoundDrawablesWithIntrinsicBounds(
                null,
                ContextCompat.getDrawable(this, newSearch),
                null,
                null
            )

            reserva.setBackgroundColor(if (textView == reserva) colorSeleccion else colorDefault)
            reserva.setTextColor(if(textView == reserva )textoSeleccion else textoDefault)
            val newReserva =
                if (textView == reserva) R.drawable.baseline_menu_white else R.drawable.baseline_menu_book
            reserva.setCompoundDrawablesWithIntrinsicBounds(
                null,
                ContextCompat.getDrawable(this, newReserva),
                null,
                null
            )

            perfil.setBackgroundColor(if (textView == perfil) colorSeleccion else colorDefault)
            perfil.setTextColor(if(textView == perfil )textoSeleccion else textoDefault)
            val newProfile =
                if (textView == perfil) R.drawable.baseline_emoji_white else R.drawable.baseline_emoji_black
            perfil.setCompoundDrawablesWithIntrinsicBounds(
                null,
                ContextCompat.getDrawable(this, newProfile),
                null,
                null
            )

        }

        seleccion(home)

        home.setOnClickListener {
            seleccion(home)



        }

        busqueda.setOnClickListener {
            seleccion(busqueda)

        }

        reserva.setOnClickListener {
            seleccion(reserva)
        }

        perfil.setOnClickListener {
            seleccion(perfil)
        }


    }
}