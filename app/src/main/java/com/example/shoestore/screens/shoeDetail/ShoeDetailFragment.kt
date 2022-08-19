package com.example.shoestore.screens.shoeDetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.ShoeDetailFragmentBinding
import com.example.shoestore.model.Shoe
import com.example.shoestore.screens.shoeListing.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private var _binding :ShoeDetailFragmentBinding? = null

    private val binding get() = _binding!!


    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ShoeDetailFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveBtn.setOnClickListener {
            val shoe = Shoe(binding.shoeName.text.toString(),binding.shoeSize.text.toString(),
                binding.shoeSize.text.toString(),binding.shoeDescription.text.toString())
            shoeViewModel.saveShoe(shoe)

        }

        binding.cancelBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        shoeViewModel.savedSuccessfully.observe(viewLifecycleOwner, Observer {
            if (it){
                Log.d("Ahmed",shoeViewModel.myShoeList.value.toString())
                findNavController().popBackStack()
                shoeViewModel.updateSuccessState(false)
            }
        })
    }

}