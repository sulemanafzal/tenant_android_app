package com.example.newshunt.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TempAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private var mFragmentList: ArrayList<Fragment> = ArrayList()
    private var mTitleList: ArrayList<String> = ArrayList()

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mTitleList.add(title)
    }

    fun getTitle(position: Int) = mTitleList[position]

    override fun getItemCount(): Int = mFragmentList.size

    override fun createFragment(position: Int): Fragment = mFragmentList[position]
}