package com.chafu.manizalezgo.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.chafu.manizalezgo.databinding.FragmentDetailBinding
import com.chafu.manizalezgo.ui.main.MainActivity
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)


        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sitioTuristico = args.sitiosTuristicos

        with(detailBinding){
            titulociudadTextView.text = sitioTuristico.nombreST
            descripcionTextView.text = sitioTuristico.descripcionST
            Picasso.get().load(sitioTuristico.urlPicture).into(mainpictureImageView)
            mapButton.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionNavigationDetailToMapsFragment(destino = sitioTuristico))
            }
        }

    }

}