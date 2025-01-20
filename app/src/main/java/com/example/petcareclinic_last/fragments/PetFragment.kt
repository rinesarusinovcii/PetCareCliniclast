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


    }





}