package com.cibertec.proyectomoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cibertec.proyectomoviles.databinding.ActivityCodigoReservaBinding

class CodigoReservaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCodigoReservaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityCodigoReservaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVolver.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        val bundle = intent.extras
        var codigo =0

        bundle?.let {
            codigo = it.getInt("KEY_ID")
        }

        binding.btnDetalle.setOnClickListener {
            val code = codigo

            val bundle = Bundle().apply {
                putInt("KEY_ID",code)
            }

            val intent = Intent(this,DetalleActivity::class.java).apply{
                putExtras(bundle)
            }
            startActivity(intent)
        }
    }
}