package com.cibertec.proyectomoviles

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.proyectomoviles.model.ImageAdapter
import com.cibertec.proyectomoviles.model.Restaurante
import com.cibertec.proyectomoviles.model.RestauranteMenuAdapter


class SearchRestaurantsFragment : Fragment() {

    private lateinit var searchList : RecyclerView
    private lateinit var menuAdapter: RestauranteMenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_restaurants, container, false)
    }

    private fun init(view: View){

        searchList = view.findViewById(R.id.rvRestayrantVertical)
        /*val restaurantes = Restaurante.populateRestaurante()
        menuAdapter = RestauranteMenuAdapter(restaurantes)
        searchList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        searchList.adapter = menuAdapter*/
    }

}