package com.jccsisc.myfirebase.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
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
}