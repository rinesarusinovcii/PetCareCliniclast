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
import com.example.petcareclinic_last.adapters.SitterAdapter
import com.example.petcareclinic_last.databinding.SitterFragmentBinding
import com.example.petcareclinic_last.helpers.UserHelper.provideRetrofit


import com.example.petcareclinic_last.models.Sitter
import retrofit2.Callback
import retrofit2.Response

class SitterFragment : Fragment() {
    private lateinit var binding: SitterFragmentBinding
    private var sitterList: List<Sitter> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SitterFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGetSitters.setOnClickListener {
            Log.d("SitterFragment", "Get Sitters button clicked")
            fetchSitters()
        }
    }

    private fun fetchSitters() {
        provideRetrofit().getSitters().enqueue(object : Callback<List<Sitter>> {
            override fun onResponse(call: Call<List<Sitter>>, response: Response<List<Sitter>>) {
                if (response.isSuccessful && response.body() != null) {
                    Log.d("SitterFragment", "Response: ${response.body()}")
                    sitterList = response.body()!!
                    val adapter = SitterAdapter(requireContext(), sitterList)
                    binding.listViewPetList.adapter = adapter

                } else {
                    Toast.makeText(requireContext(), "Error fetching sitters", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Sitter>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

       }

