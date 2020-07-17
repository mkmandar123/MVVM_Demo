package com.example.shg.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.shg.R
import com.example.shg.databinding.FragmentModeratedSubsBinding
import com.example.shg.databinding.FragmentProfileBinding
import com.example.shg.viewmodels.HomeViewModel


class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding= DataBindingUtil.inflate<FragmentProfileBinding>(inflater,R.layout.fragment_profile,container,false)
        val viewModel= ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.viewmodel=viewModel
        return binding.root
    }

}