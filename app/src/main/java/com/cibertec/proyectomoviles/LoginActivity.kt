package com.cibertec.proyectomoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val regresar4 : ImageView = findViewById(R.id.imgRegresarMain)
        val iniciar : Button = findViewById(R.id.btnIniciar)

        val usuario : TextInputEditText = findViewById(R.id.edtUserName)
        val pass : TextInputEditText = findViewById(R.id.edtPasswordLogin)

        regresar4.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        iniciar.setOnClickListener {
            val intent = Intent(this,WelcomeActivity::class.java)
            startActivity(intent)
        }
    }
}