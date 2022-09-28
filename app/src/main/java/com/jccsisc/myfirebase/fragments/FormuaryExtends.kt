package com.jccsisc.myfirebase.fragments

import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

/**
 * Project: MyFirebase
 * FROM: com.jccsisc.myfirebase.fragments
 * Created by Julio Cesar Camacho Silva on 28/09/22
 */
fun FormularyFragment.initElements() {
    binding.apply {

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
               if (snapshot.exists()) {
                   val data = snapshot.getValue(String::class.java)
                   tvData.text = "Firebase remote: $data"
               } else {
                   tvData.text = "Ruta sin datos."
               }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireActivity(), "Error al leer datos", Toast.LENGTH_SHORT).show()
            }
        }
        dataRef.addValueEventListener(listener)

        btnSend.setOnClickListener {
            val dato = tieDato.text.toString()
            dataRef.setValue(dato)
            tieDato.setText("")
        }

        btnSend.setOnLongClickListener {
            dataRef.removeValue()
            true
        }

    }
}