package com.example.shoestore.screens.logIn

import androidx.lifecycle.ViewModelProvider
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    private var _binding : FragmentLoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        _binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_login,container,false
        )
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]


        binding.lifecycleOwner = this

        binding.login.setOnClickListener {
            loginViewModel.login(binding.email.text.toString(), binding.password.text.toString())
        }

        loginViewModel.loginSuccess.observe(viewLifecycleOwner) { loginSuccessfully ->
            if (loginSuccessfully) {
                findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
            }
        }

        loginViewModel.loginFailed.observe(viewLifecycleOwner) { loginFailed ->
            if (loginFailed) {
                loginFailedMessage(R.string.error_login_msg)
            }
        }
       binding.newLogin.setOnClickListener {
           findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
       }

    }



    private fun loginFailedMessage(@StringRes errorString: Int) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}