package com.chafu.manizalezgo.data

class SitioturisticoRepository {

    suspend fun getSitioturistico () = ApiFactory.retrofit.getSitiosturisticos()

}