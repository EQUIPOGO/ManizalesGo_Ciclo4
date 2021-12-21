package com.chafu.manizalezgo.ui.list

import android.provider.Settings
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chafu.manizalezgo.data.SitioturisticoRepository
import com.chafu.manizalezgo.model.SitioTuristico
import com.chafu.manizalezgo.model.SitioTuristicoItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var sitiosLoad: MutableLiveData <ArrayList<SitioTuristicoItem>> = MutableLiveData ()
    val onSitiosLoaded: LiveData <ArrayList<SitioTuristicoItem>> = sitiosLoad

    private val repository = SitioturisticoRepository()

    fun getSitioFromServer(){
        GlobalScope.launch (Dispatchers.IO) {
            sitiosLoad.postValue ( repository.getSitioturistico())
        }
    }

    fun loadMockSitsTouristicFromJson(sitioTuristicoString: InputStream?) {
        val sitioTuristicoString = sitioTuristicoString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        sitiosLoad.value = gson.fromJson(sitioTuristicoString, SitioTuristico::class.java)
    }

}