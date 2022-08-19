package com.example.shoestore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestore.databinding.ShoeItemBinding
import com.example.shoestore.model.Shoe

class ShoeListingAdapter(
    private val shoeList : List<Shoe>
): RecyclerView.Adapter<ShoeListingViewHolder>() {

    private lateinit var binding: ShoeItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeListingViewHolder {
        binding = ShoeItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ShoeListingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoeListingViewHolder, position: Int) {
        val shoe = shoeList[position]
        holder.bind(shoe)
    }

    override fun getItemCount(): Int = shoeList.size

}