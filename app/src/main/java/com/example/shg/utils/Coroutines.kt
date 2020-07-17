package com.example.shg.utils


import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object Coroutines{
    fun background(work:suspend (()->Unit)){
        GlobalScope.launch {
            work()
        }
    }
}