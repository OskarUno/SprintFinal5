package com.awakelab.oskar.sprintfinal5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.awakelab.oskar.sprintfinal5.databinding.ArticuloLayoutBinding

class MainAdapter(tienda: List<Articulo>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    var listaArticulos = mutableListOf<Articulo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // val binding = LayoutInflater.from(parent.context).inflate(R.layout.articulo_layout,parent,false)
        val binding =
            ArticuloLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listaArticulos[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listaArticulos.size
    }

    fun setData(tienda: List<Articulo>) {
        this.listaArticulos = tienda.toMutableList()
    }

    class ViewHolder(val binding: ArticuloLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        // class ViewHolder(val binding: View) :RecyclerView.ViewHolder(binding.root) {
        fun bind(articulo: Articulo) {
            binding.tvNombre.text = articulo.nombre
            binding.tvDetalle.text = articulo.tipo
            binding.tvPrecio.text = articulo.precio.toString()
            binding.iv.load(articulo.imgUrl)
        }

    }
}