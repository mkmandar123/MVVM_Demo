package com.example.shg.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shg.api.auth.AuthApi
import com.example.shg.repository.AuthRepository

@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory (val authRepository: AuthRepository):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(authRepository) as T
    }
}