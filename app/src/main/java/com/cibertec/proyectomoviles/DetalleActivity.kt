package com.cibertec.proyectomoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.cibertec.proyectomoviles.data.Api
import com.cibertec.proyectomoviles.databinding.ActivityDetalleBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetalleActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        var codigo =0

        bundle?.let {
            codigo = it.getInt("KEY_ID")
        }


        lifecycleScope.launch{
            try {

                binding.progressBar8.visibility = View.VISIBLE

                val response = withContext(Dispatchers.IO) {
                    Api.build().getReserva(codigo)
                }
                if (response.isSuccessful) {
                    val reserva = response.body()
                    reserva?.let {

                        binding.txtNombre.text = Editable.Factory.getInstance().newEditable(it.nombres)
                        binding.txtSede2.text = Editable.Factory.getInstance().newEditable(it.direccion)
                        binding.txtCantidadPersonas.text= Editable.Factory.getInstance().newEditable(it.cantidad.toString())
                        binding.txtDia.text = Editable.Factory.getInstance().newEditable(it.fecha)
                        binding.txtHoraDiaReserva.text = Editable.Factory.getInstance().newEditable(it.hora)
                    }

                }
            } catch (ex: Exception) {
                print(ex.message)
            } finally {
                binding.progressBar8.visibility = View.GONE
            }
        }

        binding.btnInicio.setOnClickListener {
            val intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }

        binding.btnVer.setOnClickListener {
            val intent = Intent(this,CodigoReservaActivity::class.java)
            startActivity(intent)
        }
    }
}