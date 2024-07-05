package com.example.tenant.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tenant.fragment.NewRequestFragment
import com.example.tenant.fragment.OngoingFragment

class VPAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 2 // Number of fragments
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NewRequestFragment()
            1 -> OngoingFragment()
            else -> NewRequestFragment()
        }
    }
}