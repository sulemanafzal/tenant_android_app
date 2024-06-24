package com.example.tenant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.newshunt.adapter.ViewPagerAdapter
import com.example.tenant.R
import com.example.tenant.databinding.FragmentTenantAccountBinding

class TenantAccountFragment : Fragment() {
    private lateinit var _binding: FragmentTenantAccountBinding
    private lateinit var adapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTenantAccountBinding.inflate(layoutInflater, container, false)
        val view = _binding.root

// Select button 2
        _binding.btnSegmented.check(_binding.btnPostNewJob.id)

        viewPager = view.findViewById(R.id.viewPager)
        adapter = ViewPagerAdapter(requireActivity())
        viewPager.adapter = adapter

        _binding.apply {
            btnPostNewJob.setOnClickListener {
                viewPager.currentItem = 0
            }
            btnInprogress.setOnClickListener {
                viewPager.currentItem = 1
            }
            btnCompleted.setOnClickListener {
                viewPager.currentItem = 2
            }

            btnFab.setOnClickListener {
                findNavController().navigate(R.id.action_tenantAccountFragment_to_postNewJobFragment)
            }
        }


        return view
    }
}