package com.example.tenant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenant.AppPreference
import com.example.tenant.R
import com.example.tenant.databinding.FragmentRegistrationBinding
import com.example.tenant.databinding.FragmentTenantRegistrationProcessBinding
import com.example.tenant.databinding.FragmentWelcomeBinding

class TenantRegistrationProcessFragment : Fragment() {

    private var _binding: FragmentTenantRegistrationProcessBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTenantRegistrationProcessBinding.inflate(inflater, container, false)

        val view = _binding!!.root
        _binding?.apply {

            btnNext.setOnClickListener {
                findNavController().navigate(R.id.action_tenantRegistrationProcessFragment_to_tenantRegistrationSuccessFragment)
            }
        }

        return view
    }
}