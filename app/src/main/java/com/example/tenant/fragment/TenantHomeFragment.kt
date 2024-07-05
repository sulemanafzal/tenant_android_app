package com.example.tenant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tenant.Constants
import com.example.tenant.R
import com.example.tenant.adapter.RecentAdapter
import com.example.tenant.databinding.FragmentTenantHomeBinding

class TenantHomeFragment : Fragment() {

    private var _binding: FragmentTenantHomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTenantHomeBinding.inflate(layoutInflater, container, false)

        val view = _binding?.root

        val complaintList = Constants.getRecentItem(requireContext())

        _binding?.apply {
            rvRecent.layoutManager = LinearLayoutManager(requireContext())
            val adapter = RecentAdapter(requireContext(), complaintList)
            rvRecent.adapter = adapter
        }
        _binding?.apply {
            btnFab.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_postNewJobFragment)
            }
        }

        return view
    }
}