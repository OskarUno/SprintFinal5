package com.awakelab.oskar.sprintfinal5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.awakelab.oskar.sprintfinal5.databinding.ItemCarroLayoutBinding

class CarroAdapter() : RecyclerView.Adapter<CarroAdapter.ViewHolder>() {
    private lateinit var carroCompras: MutableList<Articulo>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarroAdapter.ViewHolder {
        val binding =
            ItemCarroLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarroAdapter.ViewHolder, position: Int) {
        val item = carroCompras[position]
        holder.bind(item)
    }

    fun setData(tienda: List<Articulo>) {
        this.carroCompras = tienda.toMutableList()
    }

    override fun getItemCount(): Int {
        return carroCompras.size
    }

    inner class ViewHolder(val binding: ItemCarroLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(articulo: Articulo) {
            binding.tvSkuItem.text = articulo.idItem.toString()
            binding.tvNombre.text = articulo.nombre
            binding.tvDetalle.text = articulo.tipo
            binding.tvPrecio.text = articulo.precio.toString()
            binding.iv.load(articulo.imgUrl)

           // binding.ivEliminar.setOnClickListener{}  //Para implementar
        }

    }


}