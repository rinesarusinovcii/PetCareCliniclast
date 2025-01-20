package com.example.petcareclinic_last.fragments

import android.os.Bundle
import retrofit2.Call
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.petcareclinic_last.R
import com.example.petcareclinic_last.adapters.PetAdapter
import com.example.petcareclinic_last.databinding.PetFragmentBinding
import com.example.petcareclinic_last.helpers.Helper.provideRetrofit
import com.example.petcareclinic_last.models.Pet
import retrofit2.Callback
import retrofit2.Response

class PetFragment : Fragment() {
    private lateinit var binding: PetFragmentBinding
    private var petList: List<Pet> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PetFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGetPosts.setOnClickListener {
            Log.d("PetFragment", "Get Pets button clicked")
            fetchPets()
        }
    }

    private fun fetchPets() {
        provideRetrofit().getPets().enqueue(object : Callback<List<Pet>> {
            override fun onResponse(call: Call<List<Pet>>, response: Response<List<Pet>>) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d("PetFragment", "Response: ${response.body()}")
                    petList = response.body()!!
                    val adapter = PetAdapter(requireContext(), petList)
                    binding.listViewPetList.adapter = adapter

                } else {
                    Toast.makeText(requireContext(), "Error fetching pets", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Pet>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }


}