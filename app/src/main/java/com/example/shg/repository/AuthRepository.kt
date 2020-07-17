package com.example.shg.repository

import android.util.Log
import com.example.shg.api.auth.AuthApi
import com.example.shg.api.auth.responses.LoginResponse
import com.example.shg.api.auth.responses.RegisterResponse

import java.lang.Exception

class AuthRepository(val api: AuthApi) {

   suspend fun login(username:String?,password:String?):LoginResponse?{
       var res:LoginResponse?=null
       try {
            res=api.login(username, password)
       }catch (e:Exception){
          Log.e("REPO","Exception ${e.message}")
          res=null
       }
        return res
   }

    suspend fun register(email:String,username:String,password: String):RegisterResponse?{
        var res:RegisterResponse?=null
        try {
            res=api.register(email,username,password)
        }catch (e:Exception){
            Log.e("REPO","Exception ${e.message}")
            res=null
        }
        return res
    }

}