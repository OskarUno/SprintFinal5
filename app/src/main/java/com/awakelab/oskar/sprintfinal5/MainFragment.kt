package com.awakelab.oskar.sprintfinal5

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.awakelab.oskar.sprintfinal5.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentMainBinding.inflate(layoutInflater)
        initListener()

        return binding.root
    }

    private fun initListener() {
        binding.ivCarro.setOnClickListener(fun(v:View?) {
         findNavController().navigate(R.id.action_mainFragment_to_carroFragment_btn)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemAdapter = MainAdapter()
        val articulos = Tienda.getTienda()
        itemAdapter.setData(articulos)

        println("Desde Main fragment")
        recyclerView = view.findViewById(R.id.rvMain)
        recyclerView.adapter = itemAdapter
    }

}