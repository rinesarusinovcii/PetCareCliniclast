package com.example.petcareclinic_last.services

import com.example.petcareclinic_last.models.Pet
import com.example.petcareclinic_last.models.Shop
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApiShop {
    @GET("item")
    fun getItem(): Call<List<Shop>>

    @GET("item/{id}")
    fun getItemById(@Path("id") id: Int): Call<Shop>

    @GET("item/search")
    fun searchItemByBreed(@Query("item") breed: String): Call<List<Shop>>
}