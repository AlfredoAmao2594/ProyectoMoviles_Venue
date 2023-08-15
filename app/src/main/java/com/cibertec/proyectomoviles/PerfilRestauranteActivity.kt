package com.cibertec.proyectomoviles

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Base64
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.cibertec.proyectomoviles.data.Api
import com.cibertec.proyectomoviles.databinding.ActivityLikesBinding
import com.cibertec.proyectomoviles.databinding.ActivityPerfilRestauranteBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PerfilRestauranteActivity : AppCompatActivity() {

    private lateinit var binding:ActivityPerfilRestauranteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilRestauranteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        var codigo =0

        bundle?.let {
            codigo = it.getInt("KEY_ID")
        }


        val code = codigo
        reserva (code)

        lifecycleScope.launch {
            try {

                binding.progressBar4.visibility = View.VISIBLE

                val response = withContext(Dispatchers.IO) {
                    Api.build().getRestaurant(code)
                }
                if (response.isSuccessful) {
                    val restaurante = response.body()
                    restaurante?.let {
                        val base64Image = it.imagen
                        val bitmap = base64ToBitmap(base64Image)

                        binding.imgAvatar.setImageBitmap(bitmap)
                        binding.txtNombreEstablecimiento.text = Editable.Factory.getInstance().newEditable(it.nombreRestaurante)
                        binding.txtTipoCategoria.text = Editable.Factory.getInstance().newEditable(it.categoria)
                        binding.txtDescipcion.text= Editable.Factory.getInstance().newEditable(it.descripcion)
                        binding.txtDireccionPerfil.text = Editable.Factory.getInstance().newEditable(it.direccion)
                    }

                }
            } catch (ex: Exception) {
                print(ex.message)
            } finally {
                binding.progressBar4.visibility = View.GONE
            }
        }
    }

    private fun base64ToBitmap(base64String: String): Bitmap? {
        val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
    }

    private fun reserva(codigo:Int){
        binding.txtReservar.setOnClickListener {

            val bundle = Bundle().apply {
                putInt("KEY_ID",codigo)
            }
            val intent = Intent(this,ReservaActivity::class.java).apply {
                putExtras(bundle)
            }
            startActivity(intent)
        }
    }
}