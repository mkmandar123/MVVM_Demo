package com.example.shg.utils

import android.content.Context
import android.widget.Toast



fun Context.makeToast(message:String){
        android.widget.Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}
