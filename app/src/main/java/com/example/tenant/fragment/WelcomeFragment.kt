package com.example.tenant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenant.R
import com.example.tenant.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val view = _binding?.root

        _binding?.apply {
            imgNext.setOnClickListener {
                findNavController().navigate(R.id.action_welcomeFragment_to_signUpFragment)
            }
        }

        return view
    }
}