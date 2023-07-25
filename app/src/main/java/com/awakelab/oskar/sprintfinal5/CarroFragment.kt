package com.awakelab.oskar.sprintfinal5

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

    private lateinit var sharedPref: SharedPreferences
    private var carroCompras: MutableList<Articulo> = mutableListOf()
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

        var idItem = 0
        var nombre = ""
        var tipo = ""
        var precio = 0
        var imgUrl = ""

        val carroAdapter = CarroAdapter()
        val articulos = Tienda.getTienda()

        sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)!!
        val shardAll = sharedPref.all.keys
        for (i in shardAll) {
            for (item in articulos) {

                if (item.idItem == i.toInt()) {
                    idItem = item.idItem
                    nombre = item.nombre
                    tipo = item.tipo
                    precio = item.precio
                    imgUrl = item.imgUrl
                    carroCompras.add(Articulo(idItem, nombre, tipo, precio, imgUrl))
                }
            }

            Log.d("Logger lista", i)
        }

        carroAdapter.setData(carroCompras)
        binding.rvCarro.layoutManager = LinearLayoutManager(context)
        binding.rvCarro.adapter = carroAdapter
        listeners()
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun listeners() {

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_carroFragment_to_mainFragment)
        }

        binding.deleteArticulos.setOnClickListener {
            sharedPref.edit().clear().apply()
            //   carroAdapter.notifyDataSetChanged()
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