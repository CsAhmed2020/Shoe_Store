package com.example.shoestore.screens.logIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.util.Constants
import com.example.shoestore.util.Validation

class LoginViewModel : ViewModel() {



    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean>
        get() = _loginSuccess

    private val _loginFailed = MutableLiveData<Boolean>()
    val loginFailed: LiveData<Boolean>
        get() = _loginFailed


    fun login(email:String , password : String){
        if (Validation.validateLogin(email, password)){
            _loginFailed.value = false
            Constants.EMAIL = email
            Constants.PASSWORD = password
            _loginSuccess.value = true

        }else {
            _loginFailed.value = true
        }

    }
}