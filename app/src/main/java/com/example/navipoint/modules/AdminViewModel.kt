package com.example.navipoint.modules

import com.example.navipoint.datamodels.RacePoint
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AdminViewModel {

    val db = Firebase.firestore
    fun fetchPoints() {
        db.collection("RacePoint")
            .get()
            .addOnSuccessListener { result ->

            }
    }

    fun addPoint(racePoint: RacePoint) {

    }

}