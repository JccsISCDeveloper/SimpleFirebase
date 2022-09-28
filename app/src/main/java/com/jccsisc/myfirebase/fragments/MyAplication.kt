package com.jccsisc.myfirebase.fragments

import android.app.Application
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

/**
 * Project: MyFirebase
 * FROM: com.jccsisc.myfirebase.fragments
 * Created by Julio Cesar Camacho Silva on 28/09/22
 */
class MyAplication: Application() {

    override fun onCreate() {
        super.onCreate()

        //Offline
        Firebase.database.setPersistenceEnabled(true)
    }
}