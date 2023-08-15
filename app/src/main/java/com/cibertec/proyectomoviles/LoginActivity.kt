package com.cibertec.proyectomoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.cibertec.proyectomoviles.data.Api
import com.cibertec.proyectomoviles.databinding.ActivityLoginBinding
import com.cibertec.proyectomoviles.model.Credencial
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIniciar.setOnClickListener {

            val correo = binding.edtUserName.text.toString()
            val clave = binding.edtPasswordLogin.text.toString()

            if (correo.isEmpty()){
                binding.tilUserName.error = "Debe ingresar correo"
                return@setOnClickListener
            }

            if (clave.isEmpty()){
                binding.tilPasswordLogin.error = "Debe ingresar contraseña"
                return@setOnClickListener
            }

            val intent = Intent(this,WelcomeActivity::class.java)
            startActivity(intent)

        }

       binding.imgRegresarMain.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }



}