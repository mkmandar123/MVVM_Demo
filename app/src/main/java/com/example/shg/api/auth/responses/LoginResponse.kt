package com.example.shg.api.auth.responses

data class LoginResponse(val token:String,val username:String,val email:String,val pk:Int)