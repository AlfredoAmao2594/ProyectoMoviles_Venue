package com.cibertec.proyectomoviles

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookingsFragment : Fragment() {

    private lateinit var returnHome1 : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bookings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        returnHome1 = view.findViewById(R.id.imgReturnMenu2)
        returnHome1.setOnClickListener {
            val intent = Intent(requireContext(),MenuActivity::class.java)
            startActivity(intent)
        }

    }


}