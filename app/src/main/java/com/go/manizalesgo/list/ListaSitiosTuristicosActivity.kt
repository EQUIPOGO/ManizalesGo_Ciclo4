package com.go.manizalesgo.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.go.manizalesgo.R
import com.go.manizalesgo.detalle.MainActivity
import com.go.manizalesgo.model.SitioTuristico
import com.go.manizalesgo.model.SitioTuristicoItem
import com.google.gson.Gson

class ListaSitiosTuristicosActivity : AppCompatActivity() {

    private lateinit var listaST: ArrayList<SitioTuristicoItem>
    private lateinit var sTAdapter: SitiosTuristicosAdapter
    private lateinit var sTRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_sitios_turisticos)

        sTRecyclerView = findViewById(R.id.sitios_turisticos_recycler_view)

        //listaST = createMockSitiosTuristicos()
        listaST = loadMockSitiosTuristicosFromJson()


        sTAdapter = SitiosTuristicosAdapter(onItemClicked = {onSitioTuristicoClicked(it)} ,listaST)

        //sTRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        sTRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sTAdapter
            setHasFixedSize(false)
        }
    }

    private fun onSitioTuristicoClicked(sitioturistico: SitioTuristicoItem) {

        Log.d("nombresSt", sitioturistico.nombreST)
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("sitioturistico", sitioturistico)
        startActivity(intent)

    }

    private fun loadMockSitiosTuristicosFromJson(): ArrayList<SitioTuristicoItem> {
        var sitioTuristicoString: String = applicationContext.assets.open("sitiosturisticosjason.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(sitioTuristicoString, SitioTuristico::class.java)

        return data
    }

   /* private fun createMockSitiosTuristicos() : ArrayList<SitioTuristico>{
        return arrayListOf(
            SitioTuristico(
                nombreST = "Torre el cable",
                descripcionST = "Esta torre es una estructura reticular de madera, la cual hizo parte del sistema de transporte y carga Cable Aéreo Manizales-Mariquita (inaugurado en el año 1922, prestando servicios hasta el año 1961).",
                puntuacion = "Puntuación 4.5/5.0",
                urlPicture = "https://www.dccomics.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_Superman_20190116_5c3fc2758f6a12.25513240.jpg"
                ),
            SitioTuristico(
                nombreST = "Catedral de Manizales",
                descripcionST = "La Catedral Basílica Metropolitana Nuestra Señora del Rosario se localiza frente a la plaza de Bolívar de Manizales, en el centro de esta ciudad. Esta estructura, dentro de su categoría, es la más alta de Colombia con una altura de 115 metros.",
                puntuacion = "Puntuación 4.5/5.0",
                urlPicture = "https://www.dccomics.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_Batman_20190116_5c3fc4b40faec2.47318964.jpg"
            ),
            SitioTuristico(
                nombreST = "Torre de Chipre",
                descripcionST = "Este sitio turístico se localiza en la parte alta del barrio Chipre de la ciudad de Manizales. La Torre de Chipre era un tanque de agua que suministraba del preciado líquido a los habitantes de este barrio, posteriormente, en el año 2008, fue reinaugurado como sitio turístico después de un proceso de remodelación y de reforzamiento estructural.",
                puntuacion = "Puntuación 4.5/5.0",
                urlPicture = "https://www.dccomics.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_WonderWoman_20190116_5c3fc6aa51d0e3.49076914.jpg"
            ),
            SitioTuristico(
                nombreST = "Monumento a los Colonizadores",
                descripcionST = "Metros más delante de la Torre de Chipre, se localiza el monumento a los colonizadores, el cual representa la fundación de esta ciudad cafetera dada por la colonización antioqueña. Su diseño estuvo a cargo del artista manizalita Luis Guillermo Vallejo Vargas y su construcción tardó cinco años desde 1997.",
                puntuacion = "Puntuación 4.5/5.0",
                urlPicture = "https://www.dccomics.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_Flash_20190116_5c3fcaaa18f0e8.03668117.jpg"
            ),
            SitioTuristico(
                nombreST = "Mirador Cuchilla del Salado",
                descripcionST = "Este mirador se encuentra en la parte baja de la vereda Cuchilla del salado, la cual se localiza a 10 minutos del casco urbano de la ciudad de Manizales. Este sitio, por su propia localización, ofrece una hermosa vista del paisaje cultural cafetero, además, de una espectacular panorámica de los atardeceres manizaleños.",
                puntuacion = "Puntuación 4.5/5.0",
                urlPicture = "https://www.dccomics.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_GreenLantern_20200721_5f173ad01724e2.92436411.jpg"
            )
        )
    }*/
}