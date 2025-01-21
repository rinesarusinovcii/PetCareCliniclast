package com.example.petcareclinic_last.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.petcareclinic_last.databinding.ShopItemBinding
import com.example.petcareclinic_last.models.Shop

class ShopAdapter(private val list: List<Shop>) : RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    class ShopViewHolder(private val binding: ShopItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(shop: Shop) {
            binding.shop = shop
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val rowItem = ShopItemBinding.inflate(inflater, parent, false)
        return ShopViewHolder(rowItem)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.bind(list[position])
    }
}