package com.example.petcareclinic_last.services

import retrofit2.Call
import com.example.petcareclinic_last.models.Pet
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApi {

    @GET("pets")
    fun getPets(): Call<List<Pet>>

    @GET("pets/{id}")
    fun getPetById(@Path("id") id: Int): Call<Pet>

    @GET("pets/search")
    fun searchPetsByBreed(@Query("breed") breed: String): Call<List<Pet>>
}