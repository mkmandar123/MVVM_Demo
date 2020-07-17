package com.example.shg.api.auth

import com.example.shg.api.auth.responses.LoginResponse
import com.example.shg.api.auth.responses.RegisterResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {
    @FormUrlEncoded
    @POST("login/")
   suspend fun login(@Field("username")username:String?,@Field("password")password:String?):LoginResponse

    @FormUrlEncoded
    @POST("create/")
    suspend fun register(@Field("email")email:String,@Field("username")username:String,@Field("password")password:String):RegisterResponse


companion object{
    operator fun invoke():AuthApi{
        return Retrofit.Builder().baseUrl("http://192.168.43.6:8000/users/").addConverterFactory(GsonConverterFactory.create()).build().create(AuthApi::class.java)
    }
}
}