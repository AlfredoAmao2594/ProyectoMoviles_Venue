package com.cibertec.proyectomoviles

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import com.cibertec.proyectomoviles.common.Util
import com.cibertec.proyectomoviles.data.Api
import com.cibertec.proyectomoviles.databinding.FragmentPerfilBinding
import com.cibertec.proyectomoviles.model.Restaurante
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class PerfilFragment : Fragment() {

    private lateinit var binding :FragmentPerfilBinding
    private var imageBase64 = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return return binding.root

        events()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        events()
    }

    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        binding.imgPhoto.setImageURI(uri)

        val inputStream = uri?.let {
            requireContext().contentResolver.openInputStream(it)
        }
        val imageBitmap = BitmapFactory.decodeStream(inputStream)

        GlobalScope.launch(Dispatchers.Default) {
            imageBase64 = Util.converterBase64(imageBitmap)
        }
    }

    private fun events() = with(binding){
        btnRegistraRestaurante.setOnClickListener{

            val nombre =edtNombre.text.toString()
            val categoria = edtCategoria.text.toString()
            val descripcion = edtDescripcion.text.toString()
            val direccion = edtDireccion.text.toString()
            val horaInicio = edtHoraInicio.text.toString()
            val horaFin = edtHoraFin.text.toString()
            val photo = ""

            if (nombre.isEmpty()){
                tilNombre.error = "Regsitre Nombre"
                return@setOnClickListener
            }
            if (categoria.isEmpty()){
                tilCategoria.error = "Regsitre una categoria"
                return@setOnClickListener
            }
            if (descripcion.isEmpty()){
                tilDescripcion.error = "Registre una descripcion"
                return@setOnClickListener
            }
            if (direccion.isEmpty()){
                tilDireccion.error = "Regsitre una direccion"
                return@setOnClickListener
            }
            if (horaInicio.isEmpty()){
                tilHoraInicio.error = "Registre hora de inicio"
                return@setOnClickListener
            }
            if (horaFin.isEmpty()){
                tilHoraFin.error = "Registre hora fin"
                return@setOnClickListener
            }

            lifecycleScope.launch(Dispatchers.Main) {

                try{

                    progressBar3.visibility = View.VISIBLE

                    val response = withContext(Dispatchers.IO){
                        Api.build().saveRestaurant(Restaurante(0,imageBase64,nombre,categoria,descripcion,direccion,horaInicio,horaFin))
                    }

                    if(response.isSuccessful){
                        val result = response.body()
                        result?.let {
                            if(it.error ==  true){
                                Toast.makeText(activity,it.mensaje, Toast.LENGTH_LONG).show()
                            }
                        }
                    }

                }catch (ex:Exception){
                    print(ex.message)
                }finally {
                    progressBar3.visibility = View.GONE
                    val intent = Intent(requireContext(),MenuActivity::class.java)
                    startActivity(intent)
                }

            }


        }
        imgPhoto.setOnClickListener {
            pickImage.launch("image/*")
        }
    }
}