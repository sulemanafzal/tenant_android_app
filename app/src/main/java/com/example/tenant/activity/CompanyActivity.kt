package com.example.tenant.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.tenant.R
import com.example.tenant.databinding.ActivityCompanyBinding

class CompanyActivity : AppCompatActivity() {

    private var _binding: ActivityCompanyBinding? = null

    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCompanyBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        //ADD navigation graph
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentMaintanceNav) as NavHostFragment
        navController = navHostFragment.navController

    }
}
