package com.example.tenant.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenant.R
import com.example.tenant.databinding.FragmentSignUpBinding
import com.example.tenant.databinding.FragmentWelcomeBinding

class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        val view = _binding?.root

        _binding?.apply {
            continueBtn.setOnClickListener {
                findNavController().navigate(R.id.action_signUpFragment_to_registrationFragment)
            }
        }

        return view
    }
}