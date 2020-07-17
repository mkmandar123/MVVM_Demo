package com.example.shg.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.shg.R
import com.example.shg.databinding.FragmentHomeBinding
import com.example.shg.viewmodels.HomeViewModel


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=DataBindingUtil.inflate<FragmentHomeBinding>(inflater,R.layout.fragment_home,container,false)
//        val viewModel=ViewModelProviders.of(this).get(HomeViewModel::class.java)
//        viewModel.context=this.context
//        binding.viewmodel=viewModel

        return binding.root
    }

}