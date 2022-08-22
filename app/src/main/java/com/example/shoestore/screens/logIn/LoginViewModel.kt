package com.example.shoestore.screens.logIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.util.Constants
import com.example.shoestore.util.Validation

class LoginViewModel : ViewModel() {


    val userEmail = MutableLiveData<String>()
    val userPassword = MutableLiveData<String>()

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean>
        get() = _loginSuccess

    private val _loginFailed = MutableLiveData<Boolean>()
    val loginFailed: LiveData<Boolean>
        get() = _loginFailed


    fun login(){
        if (Validation.validateLogin(userEmail.value, userPassword.value)){
            _loginFailed.value = false
            Constants.EMAIL = userEmail.value.toString()
            Constants.PASSWORD = userPassword.value.toString()
            _loginSuccess.value = true

        }else {
            _loginFailed.value = true
        }

    }
}