package com.example.petcareclinic_last.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petcareclinic_last.adapters.ShopAdapter
import com.example.petcareclinic_last.databinding.ShopFragmentBinding
import com.example.petcareclinic_last.viewModels.ShopViewModel


class ShopFragment : Fragment() {
    private lateinit var binding: ShopFragmentBinding
    private lateinit var viewModel: ShopViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ShopFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ShopViewModel::class.java]
        viewModel.getShopItems()

        observeData()
    }

    private fun observeData() {
        viewModel.shopList.observe(viewLifecycleOwner) { shopList ->
            binding.recyclerViewShop.adapter = ShopAdapter(shopList)
            binding.recyclerViewShop.layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.loading.observe(viewLifecycleOwner) { loading ->
            if (loading) {
                binding.progressBarShop.visibility = View.VISIBLE
            } else {
                binding.progressBarShop.visibility = View.GONE
            }
        }
    }
}
