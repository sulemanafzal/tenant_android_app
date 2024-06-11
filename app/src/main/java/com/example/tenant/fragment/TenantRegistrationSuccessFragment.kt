package com.example.tenant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenant.R
import com.example.tenant.databinding.FragmentTenantRegistrationSuccessBinding

class TenantRegistrationSuccessFragment : Fragment() {

    private var _binding:FragmentTenantRegistrationSuccessBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTenantRegistrationSuccessBinding.inflate(layoutInflater, container, false)

        val view = _binding!!.root

        _binding?.apply {
            btnDone.setOnClickListener {
                findNavController().navigate(R.id.action_tenantRegistrationSuccessFragment_to_tenantAccountFragment)
            }
        }

        return view
    }
}