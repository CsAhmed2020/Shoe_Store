package com.example.shoestore.screens.shoeListing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.model.Shoe

class ShoeViewModel : ViewModel() {

    private var _mutableShoeList =  mutableListOf<Shoe>()


    private val _savedSuccessfully = MutableLiveData<Boolean>()
    val savedSuccessfully: LiveData<Boolean>
        get() = _savedSuccessfully

    private var _myShoeList =  MutableLiveData<List<Shoe>>()
    val myShoeList: LiveData<List<Shoe>>
        get() = _myShoeList

     fun saveShoe(shoe:Shoe){
         _mutableShoeList.add(shoe)
         _myShoeList.value = _mutableShoeList
         updateSuccessState(true)
    }

     fun updateSuccessState(success:Boolean){
        _savedSuccessfully.value = success
    }

}