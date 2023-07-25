package com.awakelab.oskar.sprintfinal5

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import coil.load
import com.awakelab.oskar.sprintfinal5.databinding.FragmentDetalleBinding

class DetalleFragment : Fragment() {
    lateinit var binding: FragmentDetalleBinding

    private var provider = arguments?.getInt("Id")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalleBinding.inflate(layoutInflater)

        initAdapeter()
        listeners()
        return binding.root
    }

    private fun listeners() {
        binding.btnAtras.setOnClickListener { v: View? ->
            findNavController().navigate(R.id.action_detalleFragment_to_mainFragment)
        }

        binding.btnAgregarArticulo.setOnClickListener { v: View ->

            val idItem: Int = binding.tvSkuItem2.text.toString().toInt()
            val sharedPref =
                activity?.getPreferences(Context.MODE_PRIVATE) ?: return@setOnClickListener
            sharedPref.edit().putInt(idItem.toString(), idItem).apply()
            setFragmentResult("idItemAgregar", bundleOf("idItem" to idItem))
            Toast.makeText(context, "Producto Agregado $idItem", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initAdapeter() {
        provider = arguments?.getInt("Id")
        val articulos = Tienda.getTienda()
        for (item in articulos) {
            if (item.idItem == provider) {
                binding.tvSkuItem2.text = item.idItem.toString()
                binding.tvNombreDetalle.text = item.nombre
                binding.tvDetalleArticulo.text = item.tipo
                binding.tvPrecioDetalle.text = item.precio.toString()
                binding.ivDetalle.load(item.imgUrl)
            }
        }
        binding.root

    }
}