package com.jccsisc.myfirebase.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.jccsisc.myfirebase.R
import com.jccsisc.myfirebase.databinding.FragmentFormularyBinding

class FormularyFragment : Fragment(R.layout.fragment_formulary) {

    lateinit var binding: FragmentFormularyBinding

    val dataBase by lazy { Firebase.database.reference }
    val dataRef by lazy { dataBase.child("simple_firebase").child("data") }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentFormularyBinding.bind(view)
        super.onViewCreated(binding.root, savedInstanceState)

        initElements()

    }

    fun showToast(msj: String) {
        Toast.makeText(requireActivity(), msj, Toast.LENGTH_SHORT).show()
    }
}