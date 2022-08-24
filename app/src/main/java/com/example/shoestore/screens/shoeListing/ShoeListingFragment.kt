package com.example.shoestore.screens.shoeListing

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.ShoeListingFragmentBinding
import com.example.shoestore.model.Shoe

class ShoeListingFragment : Fragment() {

    private var _binding : ShoeListingFragmentBinding? = null

    private val binding get() = _binding!!

    private val shoeViewModel: ShoeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ShoeListingFragmentBinding.inflate(inflater,container,false)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addShoeFab.setOnClickListener {
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingToShoeDetail())
        }

        if (!shoeViewModel.myShoeList.value.isNullOrEmpty()){
            shoeViewModel.myShoeList.value!!.forEach { shoeItem ->
                addViews(shoeItem)
        }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.log_out -> findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingToStart())
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addViews(shoe : Shoe){
        val linearLayout = binding.container

        val item = View.inflate(this.context,R.layout.shoe_item,null)

        val name = item.findViewById<TextView>(R.id.shoe_name_txt)
        name.text = shoe.name

        val size = item.findViewById<TextView>(R.id.shoe_size_txt)
        size.text = shoe.name

        val company = item.findViewById<TextView>(R.id.shoe_company_txt)
        company.text = shoe.company

        val desc = item.findViewById<TextView>(R.id.shoe_description_txt)
        desc.text = shoe.description

        linearLayout.addView(item)
    }

}