package com.example.navipoint.datamodels

data class RacePoint(
    var id: String? = null,
    var geoPoint: String? = null,
    var difficulty: String? = null,
    var cost: Int? = null,
    var imageUrls: List<String>? = null,
    var districtId: String? = null

)
