package com.example.shg.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel


class HomeViewModel():ViewModel() {

    var context:Context?=null

// fun getUser(view:View){
//     Coroutines.background {
//         val user=userRepository.getUser()
//         withContext(Dispatchers.Main){
//             context?.makeToast("$user")
//         }
//
//     }
// }
}