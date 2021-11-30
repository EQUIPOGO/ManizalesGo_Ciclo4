package com.chafu.manizalezgo.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SitioTuristicoItem(
    @SerializedName("descripcionST")
    val descripcionST: String,
    @SerializedName("nombreST")
    val nombreST: String,
    @SerializedName("puntuacion")
    val puntuacion: String,
    @SerializedName("urlPicture")
    val urlPicture: String
) : Serializable