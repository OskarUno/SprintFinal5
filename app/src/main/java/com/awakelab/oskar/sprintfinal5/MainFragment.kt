package com.awakelab.oskar.sprintfinal5

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.awakelab.oskar.sprintfinal5.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var name: String? = null
    private var address: String? = null

    private var carroCompras: MutableList<Articulo> = mutableListOf()
    lateinit var binding: FragmentMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME_BUNDLE)
            address = it.getString(ADDRESS_BUNDLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        initListener()
        return binding.root
    }

    private fun initListener() {
        binding.ivCarro.setOnClickListener(fun(v: View?) {
            println(carroCompras)
            findNavController().navigate(R.id.action_mainFragment_to_carroFragment_btn)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemAdapter = MainAdapter { item -> onItemSelected(item) }
        val articulos = Tienda.getTienda()
        itemAdapter.setData(articulos)
        // binding.rvMain.layoutManager = GridLayoutManager(context,2)
        binding.rvMain.layoutManager = LinearLayoutManager(context)
        binding.rvMain.adapter = itemAdapter
    }

    private fun onItemSelected(articulo: Articulo) {
        Toast.makeText(context, articulo.nombre, Toast.LENGTH_LONG).show()

     //   val i = Tienda.getTienda().indexOf(articulo)
        val arg = bundleOf("Id" to articulo.idItem)
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_mainFragment_to_detalleFragment, arg)
    }
    companion object {
        private const val NAME_BUNDLE = "name_bundle"
        private const val ADDRESS_BUNDLE = "address_bundle"

        @JvmStatic
        fun newInstance(name: String, address: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(NAME_BUNDLE, name)
                    putString(ADDRESS_BUNDLE, address)
                }
            }
    }


}