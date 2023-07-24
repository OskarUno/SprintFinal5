package com.awakelab.oskar.sprintfinal5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.awakelab.oskar.sprintfinal5.databinding.ArticuloLayoutBinding

class MainAdapter(private val onClickListener: (Articulo) -> Unit) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    var listaArticulos = mutableListOf<Articulo>()

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
        holder.bind(item, onClickListener)
    }

    fun setData(tienda: List<Articulo>) {
        this.listaArticulos = tienda.toMutableList()
    }

    inner class ViewHolder(val binding: ArticuloLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(articulo: Articulo, onClickListener: (Articulo) -> Unit) {
            binding.tvNombre.text = articulo.nombre
            binding.tvDetalle.text = articulo.tipo
            binding.tvPrecio.text = articulo.precio.toString()
            binding.iv.load(articulo.imgUrl)
            itemView.setOnClickListener { onClickListener(articulo) }

        }
    }


}