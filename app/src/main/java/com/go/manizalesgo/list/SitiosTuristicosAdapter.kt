package com.go.manizalesgo.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.go.manizalesgo.R
import com.go.manizalesgo.model.SitioTuristicoItem
import com.squareup.picasso.Picasso

class SitiosTuristicosAdapter(
    private val sitiosTuristicosLista:ArrayList<SitioTuristicoItem>) :
    RecyclerView.Adapter<SitiosTuristicosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_sitioturistico_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sitioturistico = this.sitiosTuristicosLista[position]
        holder.bind(sitioturistico)

    }

    override fun getItemCount(): Int {
        return this.sitiosTuristicosLista.size

    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        private var sitioTuristicoTextView: TextView = itemview.findViewById(R.id.sitio_turistico_text_view)
        private var descripcionSTTextView: TextView = itemview.findViewById(R.id.descripcion_st_text_view)
        private var puntuacionTextView: TextView = itemview.findViewById(R.id.puntuacion_text_view)
        private var pictureImageView: ImageView = itemview.findViewById(R.id.mainpicture_image_view)

        fun bind(sitioturistico: SitioTuristicoItem){

            this.sitioTuristicoTextView.text     =   sitioturistico.nombreST
            this.descripcionSTTextView.text      =   sitioturistico.descripcionST
            this.puntuacionTextView.text         =   sitioturistico.puntuacion
            Picasso.get().load(sitioturistico.urlPicture).into(pictureImageView)

        }
    }
}