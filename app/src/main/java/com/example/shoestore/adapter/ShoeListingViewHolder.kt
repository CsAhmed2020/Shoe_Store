package com.example.shoestore.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.shoestore.databinding.ShoeItemBinding
import com.example.shoestore.model.Shoe

class ShoeListingViewHolder(
    private val binding: ShoeItemBinding
):RecyclerView.ViewHolder(binding.root) {
    fun bind(shoe: Shoe){
        binding.shoeItem = shoe
    }

}