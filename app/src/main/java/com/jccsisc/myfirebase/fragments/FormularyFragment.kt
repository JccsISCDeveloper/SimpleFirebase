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

    private lateinit var binding: FragmentFormularyBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentFormularyBinding.bind(view)
        super.onViewCreated(binding.root, savedInstanceState)

        binding.apply {

            val dataBase = Firebase.database.reference

            val listener = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val data = snapshot.getValue(String::class.java)
                    tvData.text = "Firebase remote: $data"
                }

                override fun onCancelled(error: DatabaseError) {

                }
            }

            val dataRef = dataBase.child("simple_firebase").child("data")
            dataRef.addValueEventListener(listener)

            btnSend.setOnClickListener {
                val dato = tieDato.text.toString()
                dataRef.setValue(dato)
                tieDato.setText("")
            }

        }
    }
}