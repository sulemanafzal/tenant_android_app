package com.example.tenant.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenant.R
import com.example.tenant.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private var selectedTextView: AppCompatTextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        val view = binding.root

        binding.apply {
            setupClickListener(ownerTv)
            setupClickListener(tenantTv)
            setupClickListener(ownerAndTenantTv)
            setupClickListener(mantinanceCompanyTv)
            setupClickListener(serviceProviderTv)
            setupClickListener(mantinanceAndServiceProviderTv)

            continueBtn.setOnClickListener {
                findNavController().navigate(R.id.action_signUpFragment_to_registrationFragment)
            }
        }

        return view
    }

    private fun setupClickListener(tv: AppCompatTextView) {
        tv.setOnClickListener {
            // Reset the background of the previously selected TextView
            selectedTextView?.setBackgroundResource(R.drawable.selected_background_tv)

            // Set the background of the newly selected TextView
            tv.setBackgroundResource(R.drawable.selected_background_tv)

            // Update the selected TextView reference
            selectedTextView = tv
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
