package com.example.shg.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.replace
import androidx.fragment.app.transaction
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.navigation.findNavController
import com.example.shg.R
import com.example.shg.databinding.ActivityHomeBinding
import com.example.shg.ui.fragments.home.HomeFragment
import com.example.shg.ui.fragments.home.ModeratedSubsFragment
import com.example.shg.ui.fragments.home.ProfileFragment
import com.example.shg.ui.fragments.home.SubsFragment
import com.example.shg.viewmodels.HomeViewModel

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        val binding=DataBindingUtil.setContentView<ActivityHomeBinding>(this,R.layout.activity_home)
        val viewModel=ViewModelProviders.of(this).get(HomeViewModel::class.java)

        binding.bottomNavigationView2.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.navContainer, HomeFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()

                    true
                }

                R.id.menu_profile -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.navContainer,ProfileFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()
                    true
                }
                R.id.menu_allSubs -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.navContainer,SubsFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()
                    true
                }
                R.id.menu_moderatedSubs -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.navContainer,ModeratedSubsFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()
                    true
                }

                else -> false
            }

        }

    }


}