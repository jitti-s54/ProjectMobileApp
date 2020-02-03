package com.example.petlover.ui.description

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DescripViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Description Fragment"
    }
    val text: LiveData<String> = _text
}
