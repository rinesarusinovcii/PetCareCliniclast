package com.example.petcareclinic_last.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.petcareclinic_last.helpers.ShopHelper.provideRetrofit

import com.example.petcareclinic_last.models.Shop
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShopViewModel : ViewModel() {
    private var _shopList: MutableLiveData<List<Shop>> =
        MutableLiveData(mutableListOf())

    val shopList: MutableLiveData<List<Shop>>
        get() = _shopList

    var loading = MutableLiveData<Boolean>()

    fun getShopItems() {
        loading.value = true
        provideRetrofit().getItem().enqueue(object : Callback<List<Shop>> {
            override fun onResponse(call: Call<List<Shop>>, response: Response<List<Shop>>) {
                if (response.isSuccessful && response.body() != null) {
                    _shopList.value = response.body()
                }
                loading.value = false
            }

            override fun onFailure(call: Call<List<Shop>>, t: Throwable) {
                loading.value = false
            }
        })
    }
}