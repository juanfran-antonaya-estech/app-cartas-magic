package com.juanfra.carticasmagic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
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
        val listadoCartas = helper.conseguirListadoCartas(jsonString)

        val adaptador = AdaptadorCartas(listadoCartas)
        val layoutmanager = GridLayoutManager(context, 3)

        binding.rvCartas.adapter = adaptador
        binding.rvCartas.layoutManager = layoutmanager

    }
}