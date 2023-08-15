package com.cibertec.proyectomoviles

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.cibertec.proyectomoviles.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMenuBinding
    private lateinit var  fragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_menu)

        val home: TextView = findViewById(R.id.btnMenu)
        val busqueda: TextView = findViewById(R.id.btnSearch)
        val reserva: TextView = findViewById(R.id.btnBoonkings)
        val perfil: TextView = findViewById(R.id.btnProfile)


        fun seleccion(textView: TextView) {

            val colorSeleccion = ContextCompat.getColor(this,R.color.vino)
            val textoSeleccion = Color.rgb(255,255,255)
            val colorDefault = ContextCompat.getColor(this,R.color.menu)
            val textoDefault = Color.parseColor("#757575BD")

            binding.btnMenu.setBackgroundColor(if (textView == home) colorSeleccion else colorDefault)
            home.setTextColor(if(textView == home )textoSeleccion else textoDefault)
            val newHome =
                if (textView == home) R.drawable.baseline_home_white else R.drawable.baseline_home_black
            home.setCompoundDrawablesWithIntrinsicBounds(
                null,
                ContextCompat.getDrawable(this, newHome),
                null,
                null
            )

            binding.btnSearch.setBackgroundColor(if (textView == busqueda) colorSeleccion else colorDefault)
            busqueda.setTextColor(if(textView == busqueda )textoSeleccion else textoDefault)
            val newSearch =
                if (textView == busqueda) R.drawable.baseline_search_white else R.drawable.baseline_search_black
            busqueda.setCompoundDrawablesWithIntrinsicBounds(
                null,
                ContextCompat.getDrawable(this, newSearch),
                null,
                null
            )

            binding.btnBoonkings.setBackgroundColor(if (textView == reserva) colorSeleccion else colorDefault)
            reserva.setTextColor(if(textView == reserva )textoSeleccion else textoDefault)
            val newReserva =
                if (textView == reserva) R.drawable.baseline_menu_white else R.drawable.baseline_menu_book
            reserva.setCompoundDrawablesWithIntrinsicBounds(
                null,
                ContextCompat.getDrawable(this, newReserva),
                null,
                null
            )

            binding.btnProfile.setBackgroundColor(if (textView == perfil) colorSeleccion else colorDefault)
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
        fragment = HomeFragment()
        addFragment()

        binding.btnMenu.setOnClickListener {
            seleccion(home)
            fragment = HomeFragment()
            addFragment()

        }

        binding.btnSearch.setOnClickListener {
            seleccion(busqueda)
            fragment = SearchFragment();
            addFragment()
        }

        binding.btnBoonkings.setOnClickListener {
            seleccion(reserva)
            fragment = BookingsFragment();
            addFragment()
        }

        binding.btnProfile.setOnClickListener {
            seleccion(perfil)
            fragment = PerfilFragment();
            addFragment()
        }
    }

    private fun addFragment(){
        if(fragment != null){
            supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
        }
    }
}