package com.example.tenant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenant.R
import com.example.tenant.databinding.FragmentRepairWorkBinding

class RepairWorkFragment : Fragment() {

    private lateinit var binding: FragmentRepairWorkBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentRepairWorkBinding.inflate(layoutInflater, container, false)

        binding.apply {
            btnDone.setOnClickListener {
              //  findNavController().navigate(R.id.action_repairWorkFragment_to_homeFragment)
            }
        }
        return binding.root
    }
}