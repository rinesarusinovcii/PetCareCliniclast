package com.example.petcareclinic_last.helpers

import android.content.Context
import android.content.SharedPreferences
import com.example.petcareclinic_last.services.ServiceApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Helper {
    fun provideRetrofit(): ServiceApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://freetestapi.com/api/v1/animals/") // Replace with your API base URL
            .build()
            .create(ServiceApi::class.java)
    }

    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
    }

    fun putIntToSharedPreferences(context: Context, key: String, value: Int) {
        provideSharedPreferences(context).edit().putInt(key, value).apply()
    }

    fun getIntFromSharedPreferences(context: Context, key: String): Int {
        return provideSharedPreferences(context).getInt(key, 0)
    }

    fun putStringToSharedPreferences(context: Context, key: String, value: String) {
        provideSharedPreferences(context).edit().putString(key, value).apply()
    }

    fun getStringFromSharedPreferences(context: Context, key: String): String? {
        return provideSharedPreferences(context).getString(key, null)
    }
}