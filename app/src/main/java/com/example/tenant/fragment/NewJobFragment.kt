package com.example.tenant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tenant.Constants
import com.example.tenant.adapter.JobDetailAdapter
import com.example.tenant.databinding.FragmentNewJobBinding

class NewJobFragment : Fragment() {

    private var binding: FragmentNewJobBinding? = null
    private var activity = this


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewJobBinding.inflate(layoutInflater, container, false)

        val joblist = Constants.getJobDetail(requireContext())

        binding?.apply {
            rvNewJob.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            val jobAdapter = JobDetailAdapter(joblist, requireContext())
            rvNewJob.adapter = jobAdapter
        }


        return binding?.root
    }
}
