package com.juanfra.carticasmagic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.juanfra.carticasmagic.databinding.SelectorIdiomaBinding

class AdapterGallery(val listado: ArrayList<SimpLang>) : RecyclerView.Adapter<AdapterGallery.MiCelda>() {
    inner class MiCelda (val binding: SelectorIdiomaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiCelda {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = SelectorIdiomaBinding.inflate(layoutInflater, parent, false)
        val layoutCelda = MiCelda(binding)
        return layoutCelda
    }


    override fun onBindViewHolder(holder: MiCelda, position: Int) {
        val lenguaje = listado[position]

        Glide.with(holder.binding.root)
            .load(lenguaje.imageUrl)
            .placeholder(R.drawable.placeholder)
            .into(holder.binding.ivIdioma)

        holder.binding.tvIdioma.text = lenguaje.lang

    }
    override fun getItemCount(): Int {
        return listado.size
    }
}