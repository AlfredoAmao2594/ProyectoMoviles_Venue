package com.cibertec.proyectomoviles.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.proyectomoviles.R
import com.cibertec.proyectomoviles.databinding.ItemReservaBinding
import com.cibertec.proyectomoviles.databinding.ItemRestaurantBinding

class ReservaAdapter(
    var reserva: List<reservaHecha> = emptyList(),
    val onItemDetail: (reservaHecha) -> Unit
) : RecyclerView.Adapter<ReservaAdapter.ViewHolder>() {

    inner class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding: ItemReservaBinding = ItemReservaBinding.bind(itemView)

        fun bind(reservaHecha: reservaHecha) = with(binding){
            val base64Image = reservaHecha.imagen
            val bitmap = base64ToBitmap(base64Image)

            if (bitmap != null) {
                binding.imgRestauranteReserva.setImageBitmap(bitmap)
            } else {
                println("Error al decodificar la cadena base64.")
            }

            binding.txtNombreReserva.text = reservaHecha.nombreRestaurante
            binding.txtCategoriaReserva.text = reservaHecha.categoria
            binding.txtFechaReserva2.text = reservaHecha.fecha
            binding.txtHoraReserva2.text = reservaHecha.hora

            binding.root.setOnClickListener {
                onItemDetail(reservaHecha)
            }

        }

    }

    fun updateList(reservaHecha: List<reservaHecha>) {
        this.reserva = reservaHecha
        notifyDataSetChanged()
    }

    //Inflar la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_reserva, parent, false)
        return ViewHolder(itemView)
    }

    //Cuantos elementos tiene la lista
    override fun getItemCount(): Int {
        return reserva.size
    }

    //Iterar tantas veces como elementos tenga mi lista
    override fun onBindViewHolder(holder: ReservaAdapter.ViewHolder, position: Int) {
        val reserva = reserva[position] //0
        holder.bind(reserva)
    }

    private fun base64ToBitmap(base64String: String): Bitmap? {
        val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
    }
}