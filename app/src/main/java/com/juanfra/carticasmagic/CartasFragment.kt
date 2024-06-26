package com.juanfra.carticasmagic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.juanfra.carticasmagic.databinding.FragmentCartasBinding


class CartasFragment : Fragment() {
    private lateinit var binding: FragmentCartasBinding
    private val helper = Helper()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartasBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jsonString = helper.cargarJson("json/cartas", requireActivity().assets)
        var listadoCartas = helper.conseguirListadoCartas(jsonString)
        listadoCartas = ArrayList<Carta>(listadoCartas.filter { !it.imageUrl.isNullOrEmpty() })



        val adaptador = AdaptadorCartas(listadoCartas)
        val layoutmanager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)

        binding.rvCartas.adapter = adaptador
        binding.rvCartas.layoutManager = layoutmanager

    }
}