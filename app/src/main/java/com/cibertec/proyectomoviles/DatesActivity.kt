package com.cibertec.proyectomoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class DatesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dates)

        val regresar2: ImageView = findViewById(R.id.imgRetorn2)
        val continuar2: Button = findViewById(R.id.btnContinue)
        val bundle :Bundle? = intent.extras
        var names : String? = null
        var correo :String? = null
        var clave : String?= null

        regresar2.setOnClickListener{
            val intent = Intent(this,CreateUserActivity::class.java)
            startActivity(intent)
        }



        val edtPlace: TextInputEditText = findViewById(R.id.edtLocate)
        val edtNumber: TextInputEditText = findViewById(R.id.edtNumber)

        continuar2.setOnClickListener{
            val place = edtPlace.text.toString()
            val number = edtNumber.text.toString()

            if(place.isEmpty()){
                Toast.makeText(this,"Debe ingresar lugar de residencia", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(number.isEmpty()){
                Toast.makeText(this,"Debe ingresar numero de contacto", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            bundle?.let {bundleLibreDeNulo ->
                names = bundleLibreDeNulo.getString("KEY_NAMES")?:"Desconocido"
                correo = bundleLibreDeNulo.getString("KEY_CORREO")?:"Desconocido"
                clave = bundleLibreDeNulo.getString("KEY_CLAVE")?:"Desconocido"

            }

            val nombres = names
            val correos = correo
            val claves = clave

            val bundle = Bundle().apply {

                putString("kEY_NOMBRE",nombres)
                putString("kEY_EMAIL",correos)
                putString("KEY_PASS",claves)
                putString("KEY_LUGAR", place)
                putString("KEY_NUMERO",number)

            }

            val intent = Intent(this,LikesActivity::class.java).apply {
                putExtras(bundle)
            }
            startActivity(intent)
        }



    }
}