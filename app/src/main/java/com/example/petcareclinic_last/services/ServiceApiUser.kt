package com.example.petcareclinic_last.services

import com.example.petcareclinic_last.models.Sitter
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApiUser {
    @GET("user")
    fun getSitters(): Call<List<Sitter>>

    @GET("user/{id}")
    fun getSitterById(@Path("id") id: Int): Call<Sitter>

    @GET("user/search")
    fun searchSitterByBreed(@Query("breed") breed: String): Call<List<Sitter>>

}