package com.example.navigationcomponentapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponentapp.R
import com.example.navigationcomponentapp.ui.login.LoginViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModel.autheticationStateEvent.observe(
            viewLifecycleOwner,
            { authenticationState ->
                when(authenticationState){
                    is LoginViewModel.AuthenticationState.Authenticated -> {
                        text_username.text = getString(R.string.profile_text_username, loginViewModel.username)
                    }
                    is LoginViewModel.AuthenticationState.Unauthenticated -> {
                        findNavController().navigate(R.id.loginFragment)
                    }
                }
            })
    }

}