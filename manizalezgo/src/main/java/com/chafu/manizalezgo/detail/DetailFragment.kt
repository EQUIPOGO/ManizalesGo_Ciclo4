package com.chafu.manizalezgo.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.chafu.manizalezgo.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

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
            com.squareup.picasso.Picasso.get().load(sitioTuristico.urlPicture).into(mainpictureImageView)
        }

    }

}