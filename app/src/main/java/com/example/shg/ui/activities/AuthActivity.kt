package com.example.shg.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.shg.R
import com.example.shg.api.auth.AuthApi
import com.example.shg.databinding.ActivityAuthBinding
import com.example.shg.repository.AuthRepository
import com.example.shg.viewmodels.AuthViewModel
import com.example.shg.viewmodels.AuthViewModelFactory


class AuthActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val api=AuthApi()
        val authRepository=AuthRepository(api)
        val factory=AuthViewModelFactory(authRepository)
        val binding=DataBindingUtil.setContentView<ActivityAuthBinding>(this,R.layout.activity_auth)
        val viewModel=ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)
    }


}