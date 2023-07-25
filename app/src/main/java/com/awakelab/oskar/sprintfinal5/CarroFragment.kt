package com.awakelab.oskar.sprintfinal5

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.awakelab.oskar.sprintfinal5.databinding.FragmentCarroBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CarroFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarroFragment : Fragment() {
    lateinit var binding: FragmentCarroBinding
    private lateinit var mSharedPreferences: SharedPreferences

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCarroBinding.inflate(layoutInflater)

        val carroAdapter = CarroAdapter()
        val articulos = Tienda.getTienda()
        carroAdapter.setData(articulos)
        binding.rvCarro.layoutManager = LinearLayoutManager(context)
        binding.rvCarro.adapter = carroAdapter

        listeners()
        return binding.root
    }

    private fun listeners() {

        binding.btnBack.setOnClickListener{
            findNavController().navigate(R.id.action_carroFragment_to_mainFragment)
        }

        binding.deleteArticulos.setOnClickListener{
            Log.d("Logger", "Carrito eliminado")
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CarroFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CarroFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}