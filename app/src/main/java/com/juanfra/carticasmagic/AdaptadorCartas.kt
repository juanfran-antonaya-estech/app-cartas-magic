package com.juanfra.carticasmagic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juanfra.carticasmagic.databinding.HolderCartaBinding

class AdaptadorCartas(val listado: ArrayList<Carta>) : RecyclerView.Adapter<AdaptadorCartas.CartaHolder>(){

    inner class CartaHolder(val binding: HolderCartaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartaHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderCartaBinding.inflate(layoutInflater, parent, false)
        return CartaHolder(binding)
    }

    override fun getItemCount(): Int {
        return listado.size
    }

    override fun onBindViewHolder(holder: CartaHolder, position: Int) {
        TODO("Not yet implemented")
    }


}