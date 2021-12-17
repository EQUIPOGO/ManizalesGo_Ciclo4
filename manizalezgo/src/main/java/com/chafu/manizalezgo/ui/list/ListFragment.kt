package com.chafu.manizalezgo.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.chafu.manizalezgo.databinding.FragmentListBinding
import com.chafu.manizalezgo.ui.main.MainActivity
import com.chafu.manizalezgo.model.SitioTuristico
import com.chafu.manizalezgo.model.SitioTuristicoItem
import com.google.gson.Gson

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var sTAdapter: SitiosTuristicosAdapter
    private lateinit var listaST: ArrayList<SitioTuristicoItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider (this)[ListViewModel::class.java]

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listaST = loadMockSitiosTuristicosFromJson()
        sTAdapter = SitiosTuristicosAdapter(listaST, onItemClicked = { onSitioTuristicoClicked(it) })


        listBinding.sitiosTuristicosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sTAdapter
            setHasFixedSize(false)

        }

    }

    //

    private fun onSitioTuristicoClicked(sitioturistico: SitioTuristicoItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(sitiosTuristicos = sitioturistico))
    }

    private fun loadMockSitiosTuristicosFromJson(): ArrayList<SitioTuristicoItem> {
        val sitioTuristicoString: String = context?.assets?.open("sitiosturisticosjason.json")?.bufferedReader().use { it!!.readText() } //TODO reparar!!
        val gson = Gson()
        val data = gson.fromJson(sitioTuristicoString, SitioTuristico::class.java)

        return data
    }
}