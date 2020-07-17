package com.example.shg.ui.fragments.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.shg.R
import com.example.shg.api.auth.AuthApi
import com.example.shg.databinding.FragmentLoginBinding
import com.example.shg.repository.AuthRepository
import com.example.shg.ui.activities.HomeActivity
import com.example.shg.utils.makeToast
import com.example.shg.viewmodels.AuthViewModel
import com.example.shg.viewmodels.AuthViewModelFactory


class LoginFragment : Fragment(),
    AuthListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=DataBindingUtil.inflate<FragmentLoginBinding>(inflater,R.layout.fragment_login,container,false)
        val api=AuthApi()
        val authRepository=AuthRepository(api)
        val factory=AuthViewModelFactory(authRepository)
        val viewModel= ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)
        viewModel.context=this.context
        viewModel.authListenerLogin=this
        binding.viewmodel=viewModel

        return binding.root
    }
    override fun onSuccess() {
        context?.makeToast("Logged in successfully")
        startActivity(Intent(activity, HomeActivity::class.java))

    }

    override fun onFailure() {
        context?.makeToast("Invalid Credentials")
    }
}