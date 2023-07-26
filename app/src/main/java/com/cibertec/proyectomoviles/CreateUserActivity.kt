package com.cibertec.proyectomoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class CreateUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)

        val Regresar : ImageView = findViewById(R.id.imgRetorn1)
        val Continuar : Button = findViewById(R.id.btnContinuar)

        Regresar.setOnClickListener{

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        val Nombres : TextInputEditText = findViewById(R.id.edtNames)
        val Email : TextInputEditText = findViewById(R.id.edtEmail)
        val Password : TextInputEditText = findViewById(R.id.edtPassword)

        Continuar.setOnClickListener{
            val names = Nombres.text.toString()
            val correo = Email.text.toString()
            val clave = Password.text.toString()

            if(names.isEmpty()){
                Toast.makeText(this,"Debe ingresar sus Nombres", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(correo.isEmpty()){
                Toast.makeText(this,"Debe ingresar un correo", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(clave.isEmpty()){
                Toast.makeText(this,"Debe ingresar una contraseña", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val bundle = Bundle().apply {
                putString("KEY_NAMES",names)
                putString("KEY_CORREO",correo)
                putString("KEY_CLAVE",clave)
            }

            val intent = Intent(this,DatesActivity::class.java).apply {
                putExtras(bundle)
            }
            startActivity(intent)

        }

    }
}