package com.example.shg.ui.fragments.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.shg.R
import com.example.shg.api.auth.AuthApi
import com.example.shg.databinding.FragmentRegisterBinding
import com.example.shg.repository.AuthRepository
import com.example.shg.utils.makeToast
import com.example.shg.viewmodels.AuthViewModel
import com.example.shg.viewmodels.AuthViewModelFactory


class RegisterFragment : Fragment(),
    AuthListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding=DataBindingUtil.inflate<FragmentRegisterBinding>(inflater,R.layout.fragment_register,container,false)
        val api=AuthApi()
        val authRepository=AuthRepository(api)
        val factory=AuthViewModelFactory(authRepository)
        var viewModel=ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)
        viewModel.authListenerRegister=this
        viewModel.context=this.context
        binding.viewmodel=viewModel
        return binding.root
    }

    override fun onSuccess() {
        context?.makeToast("Successfully registered")
    }

    override fun onFailure() {
        context?.makeToast("Failed")
    }

}