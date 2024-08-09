package com.example.tenant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.newshunt.adapter.ViewPagerAdapter
import com.example.tenant.R
import com.example.tenant.adapter.VPAdapter
import com.example.tenant.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var navController: NavController
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: VPAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        navController = findNavController()
        val view = _binding?.root
        if (view != null) {
            viewPager = view.findViewById(R.id.viewPager_home)
        }
        adapter = VPAdapter(requireActivity())
        viewPager.adapter = adapter
        _binding?.apply {
            btnNew.setOnClickListener {
                viewPager.currentItem = 0
            }
            btnOngoing.setOnClickListener {
                viewPager.currentItem = 1
            }
            imgEditProfile.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_editProfileFragment)
            }


        }

        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
