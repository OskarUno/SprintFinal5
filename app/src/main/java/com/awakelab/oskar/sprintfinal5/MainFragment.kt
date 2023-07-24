package com.awakelab.oskar.sprintfinal5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.awakelab.oskar.sprintfinal5.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding

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
        println("Desde Main fragment")
    }

    private fun onItemSelected(articulo: Articulo) {
        Toast.makeText(context, articulo.nombre, Toast.LENGTH_LONG).show()
        val arg = bundleOf("Id" to articulo.idItem)
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_mainFragment_to_detalleFragment, arg)
    }


}