package com.cibertec.proyectomoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cibertec.proyectomoviles.databinding.ActivityCodigoBinding

class CodigoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCodigoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCodigoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCodigo.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

    }
}