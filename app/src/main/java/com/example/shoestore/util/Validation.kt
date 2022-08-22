package com.example.shoestore.util

import android.util.Patterns

 object Validation {

    fun validateLogin(email: String?="", password: String?="") : Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()
                && !(password.isNullOrEmpty())
    }
}