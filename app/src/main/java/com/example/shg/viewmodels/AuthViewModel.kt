package com.example.shg.viewmodels


import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.shg.R
import com.example.shg.api.auth.AuthApi
import com.example.shg.repository.AuthRepository
import com.example.shg.ui.fragments.auth.AuthListener
import com.example.shg.utils.Coroutines
import com.example.shg.utils.makeToast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception


class AuthViewModel(val authRepository: AuthRepository):ViewModel() {

    var username:String?=null
    var email:String?=null
    var password:String?=null
    var context:Context?=null
    var authListenerLogin: AuthListener?=null
    var authListenerRegister: AuthListener?=null


    fun onLoginClicked(view: View){
        Coroutines.background {
           val res= authRepository.login(username,password)

                withContext(Dispatchers.Main){
                    if(res==null)
                        authListenerLogin?.onFailure()
                    else
                        authListenerLogin?.onSuccess()
                }
//            userRepository.saveUser(UserEntity("${res?.token}","${res?.email}","${res?.username}",res!!.pk))
        }
    }

    fun onRegistrationLink(view:View){
        view.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

    fun onRegisterClicked(view: View){
        Coroutines.background {
            try {
               val res= authRepository.register(email!!,username!!,password!!)

                withContext(Dispatchers.Main){if(res?.token==null)
                    authListenerRegister?.onFailure()
                else
                   authListenerRegister?.onSuccess()}
            }catch (e:Exception){
                withContext(Dispatchers.Main){
                    Log.e("viewModel","Register exception ${e.message}")
                    context?.makeToast("Enter details")
                }

            }

        }
    }
}