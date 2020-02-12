package com.example.petlover.ui.description

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.petlover.R
import com.example.petlover.ui.animaldetail.Animaldetail
import com.example.petlover.ui.home.HomeFragment


class Descrip : Fragment() {

    private lateinit var DescripviewModel: DescripViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DescripviewModel =
            ViewModelProviders.of(this).get(DescripViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_addpet, container, false)
        return root
    }

}
