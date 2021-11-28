package com.go.manizalesgo.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.go.manizalesgo.databinding.ActivityMainBinding
import com.go.manizalesgo.model.SitioTuristicoItem
import com.squareup.picasso.Picasso
import java.io.Serializable


class MainActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityMainBinding //SINTAXIS PROPIA ASIGNADA POR ANDROID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val sitioturistico: SitioTuristicoItem = intent.extras?.getSerializable("sitioturistico") as SitioTuristicoItem

        with(detalleBinding){
            titulociudadTextView.text = sitioturistico.nombreST
            descripcionTextView.text = sitioturistico.descripcionST
            Picasso.get().load(sitioturistico.urlPicture).into(mainpictureImageView)
        }



    }
}