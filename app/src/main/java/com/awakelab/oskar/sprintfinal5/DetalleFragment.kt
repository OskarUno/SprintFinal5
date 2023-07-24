package com.awakelab.oskar.sprintfinal5

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.awakelab.oskar.sprintfinal5.databinding.FragmentDetalleBinding

class DetalleFragment : Fragment(), MainAdapter.ArticuloCallback {
    lateinit var binding: FragmentDetalleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalleBinding.inflate(layoutInflater)

//        val id = arguments?.getString("Id")
        Log.d("Logger","Desde OnCreate DetalleFragment")
//        binding.tvNombreDetalle.text = id.toString()
        initAdapeter()




        return  binding.root

    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        println("Desde onCrteateView")
//        val provider = arguments?.getString("Id")
//        println("Desde onCrteateView $provider")
//        FragmentDetalleBinding.inflate(layoutInflater).tvNombreDetalle.text = provider.toString()
//    }

    override fun showArticulo(nombre: String) {
        Log.d("Logger","Desde ShowArticulo DetalleFragment, $nombre")
        binding.tvNombreDetalle.text = nombre
    }

    private fun initAdapeter(){
        val provider = arguments?.getString("Id")
        val articulos = Tienda.getTienda()
        for(item in articulos ){
           if(item.idItem == provider) {
               Log.d("Logger", "Igual ${item.nombre}")
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