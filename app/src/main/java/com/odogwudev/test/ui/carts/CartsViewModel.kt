package com.odogwudev.test.ui.carts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CartsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Cart Section"
    }
    val text: LiveData<String> = _text
}