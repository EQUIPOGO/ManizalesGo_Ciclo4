package com.go.manizalesgo.model


import com.google.gson.annotations.SerializedName

data class SitioTuristicoItem(
    @SerializedName("descripcionST")
    val descripcionST: String,
    @SerializedName("nombreST")
    val nombreST: String,
    @SerializedName("puntuacion")
    val puntuacion: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)