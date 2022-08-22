package com.example.shoestore.screens.shoeDetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.ShoeDetailFragmentBinding
import com.example.shoestore.screens.shoeListing.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private var _binding :ShoeDetailFragmentBinding? = null

    private val binding get() = _binding!!


    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ShoeDetailFragmentBinding.inflate(inflater,container,false)

        binding.shoeViewModel = shoeViewModel
        binding.lifecycleOwner = this

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        shoeViewModel.savedSuccessfully.observe(viewLifecycleOwner, Observer {
            if (it){
                Log.d("Ahmed",shoeViewModel.myShoeList.value.toString())
                findNavController().navigateUp()
                shoeViewModel.updateSuccessState(false)
            }
        })

        shoeViewModel.savedFailed.observe(viewLifecycleOwner, Observer {
            if (it){
                savedFailedMessage(R.string.saved_failed_message)
            }
        })

        shoeViewModel.cancel.observe(viewLifecycleOwner, Observer {
            if (it){
                findNavController().popBackStack()
                shoeViewModel.cancelProcess(false)
            }
        })
    }

    private fun savedFailedMessage(@StringRes errorString: Int) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
    }

}