package com.example.tenant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tenant.Constants
import com.example.tenant.R
import com.example.tenant.adapter.InProgressAdapter
import com.example.tenant.adapter.JobDetailAdapter
import com.example.tenant.databinding.FragmentInProgressBinding
import com.example.tenant.databinding.FragmentTenantRegistrationProcessBinding

class InProgressFragment : Fragment() {

    private var _binding: FragmentInProgressBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentInProgressBinding.inflate(layoutInflater, container, false)

        val view = _binding?.root


        val joblist = Constants.getJobDetail()

        _binding?.apply {
            rvInProgress.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            val jobAdapter = InProgressAdapter(joblist, requireContext())
            rvInProgress.adapter = jobAdapter
        }


        return view
    }
}