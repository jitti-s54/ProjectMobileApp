package com.example.petlover.ui.animaldetail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.petlover.R

class Animaldetail : Fragment() {

    companion object {
        fun newInstance() = Animaldetail()
    }

    private lateinit var viewModel: AnimaldetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animaldetail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AnimaldetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
