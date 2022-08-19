package com.example.shoestore.screens.shoeListing

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoestore.adapter.ShoeListingAdapter
import com.example.shoestore.databinding.ShoeListingFragmentBinding

class ShoeListingFragment : Fragment() {

    private var _binding : ShoeListingFragmentBinding? = null

    private val binding get() = _binding!!

    private val shoeViewModel: ShoeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ShoeListingFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addShoeFab.setOnClickListener {
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingToShoeDetail())
        }
        shoeViewModel.myShoeList.observe(viewLifecycleOwner, Observer {
            Log.d("AhmedList",it.toString())
        })

        val recyclerView = binding.shoeListingRv
        val adapter = shoeViewModel.myShoeList.value?.let { ShoeListingAdapter(it) }
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)
    }


}