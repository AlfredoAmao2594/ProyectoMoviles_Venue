package com.cibertec.proyectomoviles

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import com.cibertec.proyectomoviles.data.Api
import com.cibertec.proyectomoviles.databinding.FragmentBookingsBinding
import com.cibertec.proyectomoviles.databinding.FragmentHomeBinding
import com.cibertec.proyectomoviles.databinding.ItemReservaBinding
import com.cibertec.proyectomoviles.model.ReservaAdapter
import com.cibertec.proyectomoviles.model.reservaHecha
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BookingsFragment : Fragment() {

    private lateinit var returnHome1: ImageView
    private lateinit var binding: FragmentBookingsBinding

    private var reservaAdapter = ReservaAdapter(onItemDetail ={reservaHecha ->

        val bundle = Bundle().apply {
            putInt("KEY_ID",reservaHecha.id)
        }
        val intent = Intent(requireContext(), CodigoReservaActivity::class.java).apply {
            putExtras(bundle)
        }
        startActivity(intent)
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBookingsBinding.inflate(inflater, container, false)
        return binding.root

        initList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        returnHome1 = view.findViewById(R.id.imgReturnMenu2)
        returnHome1.setOnClickListener {
            val intent = Intent(requireContext(), MenuActivity::class.java)
            startActivity(intent)
        }

        initList()

    }

    override fun onStart() {
        super.onStart()
        getReservas()
    }

    private fun initList() {
        binding.rvReservas.adapter = reservaAdapter
    }

    private fun getReservas() {
        lifecycleScope.launch {

            try {
                binding.progressBar7.visibility = View.VISIBLE

                val response = withContext(Dispatchers.IO) {
                    Api.build().getAllReserva()
                }
                Log.d(ContentValues.TAG, "Respuesta exitosa")

                if (response.isSuccessful) {
                    val reserva = response.body()
                    Log.d(ContentValues.TAG, "Respuesta exitosa: ")
                    reserva?.let {
                        reservaAdapter.updateList(it)
                    }
                }
            } catch (ex: Exception) {
                print(ex.message)
            } finally {
                binding.progressBar7.visibility = View.GONE
            }
        }
    }

}