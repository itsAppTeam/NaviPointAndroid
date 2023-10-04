package com.example.navipoint.datamodels

data class District(
    var id: String? = null,
    var title: String? = null,
    var geoPoint: String? = null
)


data class City (
    val coords: Coords,
    val district: String,
    val name: String,
    val population: Long,
    val subject: String
)

data class Coords (
    val lat: String,
    val lon: String
)
