package com.awakelab.oskar.sprintfinal5

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.awakelab.oskar.sprintfinal5.databinding.FragmentDetalleBinding

class DetalleFragment : Fragment() {
    lateinit var binding: FragmentDetalleBinding
    var sp  = 0;
    var carroCompras = mutableListOf<Articulo>()
    private var provider =  arguments?.getString("Id")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalleBinding.inflate(layoutInflater)


        Log.d("Logger", "Desde OnCreate DetalleFragment")
        initAdapeter()
        listeners()
        return binding.root
    }

    private fun listeners() {
        binding.btnAtras.setOnClickListener { v: View? ->
            findNavController().navigate(R.id.action_detalleFragment_to_mainFragment)
        }

        binding.btnAgregarArticulo.setOnClickListener { v: View ->

            val idItem: String = binding.tvSkuItem2.text.toString()
            val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return@setOnClickListener
            sharedPref.edit().putString(idItem, idItem).apply()


           // provider?.let { Tienda.getTienda()[it.toInt()-1] }?.let { carroCompras.add(it) }
          //  carroCompras.add(Articulo())
          //  Log.d("Logger",carroCompras.toString())

         //   val nombre: String = binding.tvNombreDetalle.text.toString()
            Toast.makeText(context, "Producto Agregado $idItem" , Toast.LENGTH_SHORT).show()

        }
    }

    private fun initAdapeter() {
         provider = arguments?.getString("Id")
        val articulos = Tienda.getTienda()
        for (item in articulos) {
            if (item.idItem == provider) {
                Log.d("Logger", "Igual ${item.nombre}")
                binding.tvSkuItem2.text =  item.idItem
                binding.tvNombreDetalle.text = item.nombre
                binding.tvDetalleArticulo.text = item.tipo
                binding.tvPrecioDetalle.text = item.precio.toString()
                binding.ivDetalle.load(item.imgUrl)
            }
        }

        Log.d("Logger", "Desde initAdapeter $provider")

        binding.root

    }
}