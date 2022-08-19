package com.example.shoestore.screens.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    private var _binding : WelcomeFragmentBinding?=null

    private val binding get() = _binding!!

    companion object {
        fun newInstance() = WelcomeFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WelcomeFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextBtn.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeToInstructions())
        }
    }

}