package com.example.petcareclinic_last.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.petcareclinic_last.R
import com.example.petcareclinic_last.databinding.HomeFragmentBinding
import com.example.petcareclinic_last.databinding.PetFragmentBinding

class HomeFragment : Fragment() {
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using ViewBinding
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigate to SittersFragment when rectangle1 is clicked
        binding.rectangle1.setOnClickListener {
            findNavController().navigate(R.id.petFragment)
        }

        // Navigate to PetFragment when rectangle2 is clicked
        binding.rectangle2.setOnClickListener {
            findNavController().navigate(R.id.sitterFragment)
        }
    }
}