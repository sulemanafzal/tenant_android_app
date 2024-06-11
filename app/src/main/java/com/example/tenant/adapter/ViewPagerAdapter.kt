package com.example.newshunt.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tenant.fragment.CompletedFragment
import com.example.tenant.fragment.InProgressFragment
import com.example.tenant.fragment.NewJobFragment

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 3 // Number of fragments
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NewJobFragment()
            1 -> InProgressFragment()
            2 -> CompletedFragment()
            else -> NewJobFragment()
        }
    }
}
