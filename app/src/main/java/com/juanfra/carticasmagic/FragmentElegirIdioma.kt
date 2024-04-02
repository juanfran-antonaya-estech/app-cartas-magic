package com.juanfra.carticasmagic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juanfra.carticasmagic.databinding.FragmentElegirIdiomaBinding


class FragmentElegirIdioma : Fragment() {

    private lateinit var binding: FragmentElegirIdiomaBinding
    private lateinit var adaptador: AdapterGallery
    val helper = Helper()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentElegirIdiomaBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_elegir_idioma, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var carta = FragmentCartaDetalle.getCarta()
        var language = FragmentCartaDetalle.getDefLang()

        adaptador = AdapterGallery(helper.getIdiomas(carta))
        binding.vpIdiomas.adapter = adaptador
    }
}