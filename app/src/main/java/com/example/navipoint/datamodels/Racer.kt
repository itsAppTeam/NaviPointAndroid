package com.example.navipoint.datamodels

data class Racer(
    var id: String? = null,
    var name: String? = null,
    var phone: String? = null,
    var district: String? = null,
    var races: List<MotoRace>? = null,
    var pickedPoint: RacePoint? = null
)
