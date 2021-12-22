package com.chafu.manizalezgo.data

import com.chafu.manizalezgo.model.SitioTuristico
import retrofit2.http.GET

interface ApiService {

    @GET("EQUIPOGO/ManizalesGo_Ciclo4/sitiosturisticos")
    suspend fun getSitiosturisticos (): SitioTuristico

}