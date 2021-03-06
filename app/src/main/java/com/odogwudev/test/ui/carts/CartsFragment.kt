package com.odogwudev.test.ui.carts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.odogwudev.test.R

class CartsFragment : Fragment() {

    private lateinit var cartsViewModel: CartsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cartsViewModel =
            ViewModelProvider(this).get(CartsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_carts, container, false)
        val textView: TextView = root.findViewById(R.id.text_cart)
        cartsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}