package com.example.petcareclinic_last.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.petcareclinic_last.databinding.ShopItemBinding
import com.example.petcareclinic_last.models.Shop
import com.squareup.picasso.Picasso

class ShopAdapter(private val list: List<Shop>) :
    RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    class ShopViewHolder(private val binding: ShopItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(shop: Shop) {
            binding.shop = shop

            // Use Picasso to load the image
            Picasso.get()
                .load(shop.image) // Load the image URL
                .placeholder(android.R.drawable.ic_menu_gallery) // Placeholder while loading
                .error(android.R.drawable.ic_menu_close_clear_cancel) // Error image
                .into(binding.ivPetPic) // Target ImageView

            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val rowItem = ShopItemBinding.inflate(inflater, parent, false)
        return ShopViewHolder(rowItem)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.bind(list[position])
    }
}
