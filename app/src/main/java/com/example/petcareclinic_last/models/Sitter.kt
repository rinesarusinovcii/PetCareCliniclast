package com.example.petcareclinic_last.models

data class Sitter(
    var id: Int,
    var picture: String,
    var name: String,
    var email: String,
    var phoneNumber: String,
    var descriptionSitter: String
)
