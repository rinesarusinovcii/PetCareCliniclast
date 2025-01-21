package com.example.petcareclinic_last.models

data class Shop(
    var id: Int,
    var title : String,
    var price : Double,
    var description : String,
    var category : String,
    var image :Int,
    var rating : Rating

)

data class Rating(
    var rate : Double,
    var count : Int
)