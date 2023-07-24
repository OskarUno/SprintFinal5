package com.awakelab.oskar.sprintfinal5

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.awakelab.oskar.sprintfinal5.databinding.ArticuloLayoutBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    var listaArticulos = mutableListOf<Articulo>()
    var callback: ArticuloCallback? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ArticuloLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listaArticulos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listaArticulos[position]
        holder.bind(item)
    }

    fun setData(tienda: List<Articulo>) {
        this.listaArticulos = tienda.toMutableList()
    }

    inner class ViewHolder(val binding: ArticuloLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(articulo: Articulo) {
            binding.tvNombre.text = articulo.nombre
            binding.tvDetalle.text = articulo.tipo
            binding.tvPrecio.text = articulo.precio.toString()
            binding.iv.load(articulo.imgUrl)

            //Callback
          //  binding.cardViewItem.setOnClickListener(fun(v: View?) {
            binding.cardViewItem.setOnClickListener(View.OnClickListener {
               val arg = bundleOf("Id" to articulo.idItem)
                val nombre = "Nombre: ${articulo.nombre}"
               Log.d("Logger", "Desde MainAdapter onClick $nombre")
               callback?.showArticulo(nombre)
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_mainFragment_to_detalleFragment,arg)
            })
        }
    }

    interface ArticuloCallback {
        fun showArticulo(nombre: String)

    }

}