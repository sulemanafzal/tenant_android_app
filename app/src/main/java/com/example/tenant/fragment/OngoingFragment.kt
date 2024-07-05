package com.example.tenant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tenant.R
import com.example.tenant.databinding.FragmentOngoingBinding

class OngoingFragment : Fragment() {
    private lateinit var binding:FragmentOngoingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=  FragmentOngoingBinding.inflate(layoutInflater, container, false)


        binding.apply {
            tvViewDescription.setOnClickListener {
                if (tVDescription.visibility == View.GONE) {
                    tVDescription.visibility = View.VISIBLE
                    tvViewDescription.text = "Click to Hide Description"
                } else {
                    tVDescription.visibility = View.GONE
                    tvViewDescription.text = "Click to View Description"
                }
            }
        }



        return binding.root

    }
}