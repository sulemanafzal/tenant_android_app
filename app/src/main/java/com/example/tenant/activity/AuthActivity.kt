package com.example.tenant.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.tenant.R
import com.example.tenant.StatusBarManager
import com.example.tenant.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private var _binding: ActivityAuthBinding? = null
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)


        StatusBarManager.changeStatusBarColor(this, window, R.color.white)


        //ADD navigation graph
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

    }
}
