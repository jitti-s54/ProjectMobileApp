package com.example.petlover.ui.description

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer

import com.example.petlover.R

class Descrip : Fragment() {

    private lateinit var DescripviewModel: DescripViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DescripviewModel =
            ViewModelProviders.of(this).get(DescripViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_descrip, container, false)

        return root
    }
}
