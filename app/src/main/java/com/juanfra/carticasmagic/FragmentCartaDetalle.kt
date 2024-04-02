package com.juanfra.carticasmagic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.juanfra.carticasmagic.databinding.FragmentCartaDetalleBinding


class FragmentCartaDetalle : Fragment() {

    private lateinit var binding: FragmentCartaDetalleBinding
    private val helper = Helper()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartaDetalleBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val helper = Helper()

        var carta = getCarta()
        var defLang = getDefLang()

        actualizarLayout(carta, defLang)

        binding.ivCartaDetallada.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentCartaDetalle_to_fragmentElegirIdioma)
        }
    }

    private fun actualizarLayout(carta: Carta, lang: String) {
        Glide.with(this)
            .load(helper.getImageLang(carta, lang))
            .placeholder(R.drawable.placeholder)
            .into(binding.ivCartaDetallada)
        aniadirTexto("Nombre: ${helper.getNameLang(carta, lang)}")
        aniadirTexto("Coste de maná: ${carta.manaCost}")
        aniadirTexto("CMC: ${carta.cmc}")
        aniadirArraylist("Colores:", carta.colors)
        aniadirArraylist("Identidad de colores", carta.colorIdentity)
        aniadirTexto("Tipo: ${helper.getTypeLang(carta, lang)}")
        aniadirTexto("Rareza: ${carta.rarity}")
        aniadirTexto("Set: ${carta.set}")
        aniadirTexto("Nombre del set: ${carta.setName}")
        aniadirTexto("Texto:\n ${helper.getTextLang(carta, lang)}")
        aniadirTexto("Flavor:\n ${helper.getFlavorLang(carta, lang)}")
        aniadirTexto("Artista: ${carta.artist}")
        aniadirTexto("Número: ${carta.number}")
        aniadirTexto("Poder: ${carta.power} | Resistencia: ${carta.toughness}")
        aniadirTexto("Layout: ${carta.layout}")
        aniadirArraylist("Prints: ", carta.printings)
        aniadirTexto("Texto Original: ${carta.originalText}")
        aniadirTexto("Tipo Original: ${carta.originalType}")
        aniadirLegalities(carta.legalities)


    }

    private fun aniadirLegalities(legalities: java.util.ArrayList<Legality>?) {
        val hll = LinearLayout(this.context)
        val desc = TextView(this.context)
        desc.text = "Legalities: "
        val vll2 = LinearLayout(this.context)


        hll.orientation = LinearLayout.HORIZONTAL
        vll2.orientation = LinearLayout.VERTICAL
        for (i in legalities!!) {
            val tv = TextView(this.context)
            tv.text = "${i.format} | ${i.legality}"
            vll2.addView(tv)
        }
        hll.setPadding(10,10,10,10)


        hll.addView(desc)
        hll.addView(vll2)
        binding.vll.addView(hll)
    }

    private fun aniadirArraylist(text: String, array: ArrayList<String>?) {
        val hll = LinearLayout(this.context)
        val desc = TextView(this.context)
        desc.text = text
        val vll2 = LinearLayout(this.context)


        hll.orientation = LinearLayout.HORIZONTAL
        vll2.orientation = LinearLayout.VERTICAL
        for (i in array!!) {
            val tv = TextView(this.context)
            tv.text = i
            vll2.addView(tv)
        }
        hll.setPadding(10,10,10,10)


        hll.addView(desc)
        hll.addView(vll2)
        binding.vll.addView(hll)
    }

    private fun aniadirTexto(text: String) {
        val tv = TextView(this.context)
        tv.text = text
        tv.width = binding.vll.width
        tv.setPadding(10,10,10,10)
        binding.vll.addView(tv)
    }

    companion object {
        private lateinit var ultimacarta: Carta
        private lateinit var defLang: String
        fun setCarta(carta: Carta) {
            ultimacarta = carta
        }
        fun getCarta() : Carta {
            return ultimacarta
        }
        fun setDefLang(lang: String){
            defLang = lang
        }
        fun getDefLang() : String {
            return defLang
        }

    }
}