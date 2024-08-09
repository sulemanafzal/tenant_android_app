package com.example.tenant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tenant.AppPreference
import com.example.tenant.Constants
import com.example.tenant.adapter.NewRequiestAdapter
import com.example.tenant.databinding.FragmentNewRequestBinding

class NewRequestFragment : Fragment() {
    private lateinit var binding: FragmentNewRequestBinding
    private var preference : AppPreference?= null
    private var isArabicLangSelected = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewRequestBinding.inflate(layoutInflater, container, false)

        val view = binding.root

        isArabicLangSelected = !preference?.languageCode.equals("en", true)

        val listNewRequest = Constants.getnewRequistItem(requireContext())

        binding.apply {
            preference = AppPreference.getInstance(requireContext())
            rvNewRwquist.layoutManager = LinearLayoutManager(requireContext())
            val adapter = NewRequiestAdapter(requireContext(), listNewRequest)
            rvNewRwquist.adapter = adapter
        }

        return view
    }
}