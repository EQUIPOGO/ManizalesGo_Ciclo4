package com.chafu.manizalezgo.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.chafu.manizalezgo.databinding.FragmentListBinding
import com.chafu.manizalezgo.model.SitioTuristicoItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var sTAdapter: SitiosTuristicosAdapter
    private var listaST: ArrayList<SitioTuristicoItem> = arrayListOf()

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
       // (activity as MainActivity?)?.hideIcon()
      //  listViewModel.loadMockSitsTouristicFromJson(context?.assets?.open("sitiosturisticosjason.json"))

        listViewModel.getSitioFromServer()

        listViewModel.onSitiosLoaded.observe(viewLifecycleOwner, {result ->
            onSitiosLoadedSubscribe (result)

        })
        SitiosTuristicosAdapter(listaST, onItemClicked = { onSitioTuristicoClicked(it) }).also { sTAdapter = it }

        listBinding.sitiosTuristicosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sTAdapter
            setHasFixedSize(false)
        }


    }

    private fun onSitiosLoadedSubscribe(result: ArrayList<SitioTuristicoItem>?) {
        result?.let{ listaST ->
            sTAdapter.appendItems (listaST)
        }


    }

    //

    private fun onSitioTuristicoClicked(sitioturistico: SitioTuristicoItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(sitiosTuristicos = sitioturistico))
    }


}