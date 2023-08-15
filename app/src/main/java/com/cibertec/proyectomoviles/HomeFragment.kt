package com.cibertec.proyectomoviles

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.cibertec.proyectomoviles.data.Api
import com.cibertec.proyectomoviles.databinding.FragmentHomeBinding
import com.cibertec.proyectomoviles.model.ImageAdapter
import com.cibertec.proyectomoviles.model.Restaurante
import com.cibertec.proyectomoviles.model.RestauranteMenuAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Math.abs

class HomeFragment : Fragment() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var handler : Handler
    private lateinit var imageList:ArrayList<Int>
    private lateinit var adapter: ImageAdapter

    private lateinit var binding: FragmentHomeBinding

    private var restauranteMenuAdapter=RestauranteMenuAdapter(onItemDetail = {restaurante ->

        val bundle = Bundle().apply {
            putInt("KEY_ID",restaurante.id)
        }
        val intent = Intent(requireContext(), PerfilRestauranteActivity::class.java).apply {
            putExtras(bundle)
        }
        startActivity(intent)
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

        initList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        initList()
        setUpTransformer()

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)
            }
        })
    }

    override fun onStart() {
        super.onStart()
        getResturants()
    }

    override fun onPause() {
        super.onPause()

        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()

        handler.postDelayed(runnable , 2000)
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    private fun setUpTransformer(){
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }

        viewPager2.setPageTransformer(transformer)
    }

    private fun init(view: View){
        viewPager2 = view.findViewById(R.id.viewPager2)
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.banner1)
        imageList.add(R.drawable.banner2)
        imageList.add(R.drawable.banner3)
        imageList.add(R.drawable.banner4)
        imageList.add(R.drawable.banner5)


        adapter = ImageAdapter(imageList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

    }

    private fun initList(){
        binding.rvMenuHome.adapter = restauranteMenuAdapter
    }
    private fun getResturants() {
        lifecycleScope.launch {

            try {
                binding.progressBar5.visibility = View.VISIBLE

                val response = withContext(Dispatchers.IO) {
                    Api.build().getAllRestaurant()
                }
                Log.d(TAG, "Respuesta exitosa")

                if (response.isSuccessful) {
                    val restaurante = response.body()
                    Log.d(TAG, "Respuesta exitosa: ")
                    restaurante?.let {
                        restauranteMenuAdapter.updateList(it)
                    }
                }

            } catch (ex: Exception) {
                print(ex.message)
            } finally {
                binding.progressBar5.visibility = View.GONE
            }
        }
    }
}