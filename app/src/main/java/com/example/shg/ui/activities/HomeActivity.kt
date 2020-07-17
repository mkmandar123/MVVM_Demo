package com.example.shg.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.example.shg.R
import com.example.shg.databinding.ActivityHomeBinding
import com.example.shg.viewmodels.HomeViewModel

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        val binding=DataBindingUtil.setContentView<ActivityHomeBinding>(this,R.layout.activity_home)
        val viewModel=ViewModelProviders.of(this).get(HomeViewModel::class.java)

    }
}