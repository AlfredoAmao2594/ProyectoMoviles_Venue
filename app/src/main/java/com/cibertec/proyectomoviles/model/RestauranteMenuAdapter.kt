package com.cibertec.proyectomoviles.model


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.proyectomoviles.R
import com.cibertec.proyectomoviles.databinding.ItemRestaurantBinding
import java.io.ByteArrayInputStream


class RestauranteMenuAdapter (
    var restaurantes: List<Restaurante> = emptyList(),
    val onItemDetail: (Restaurante) -> Unit
    ) : RecyclerView.Adapter<RestauranteMenuAdapter.ViewHolder>() {

    inner class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding: ItemRestaurantBinding = ItemRestaurantBinding.bind(itemView)

        fun bind(restaurante: Restaurante) = with(binding){
            val base64Image = restaurante.imagen
            val bitmap = base64ToBitmap(base64Image)

            if (bitmap != null) {
                binding.imgRestaurant.setImageBitmap(bitmap)
            } else {
                println("Error al decodificar la cadena base64.")
            }

            binding.tvNameRestaurant.text = restaurante.nombreRestaurante
            binding.txtHoraInicio.text = restaurante.horaInicio
            binding.txtHoraFin.text = restaurante.horaFin

            binding.root.setOnClickListener {
                onItemDetail(restaurante)
            }

        }

    }

    fun updateList(restaurante: List<Restaurante>) {
        this.restaurantes = restaurante
        notifyDataSetChanged()
    }

    //Inflar la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return ViewHolder(itemView)
    }

    //Cuantos elementos tiene la lista
    override fun getItemCount(): Int {
        return restaurantes.size
    }

    //Iterar tantas veces como elementos tenga mi lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val restaurante = restaurantes[position] //0
        holder.bind(restaurante)
    }

    private fun base64ToBitmap(base64String: String): Bitmap? {
        val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
    }

}