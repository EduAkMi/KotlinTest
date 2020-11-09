package com.example.kotlintest.bProjectB

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabLayoutAdapter(private val list: List<String>, private val listFragments: List<Fragment>, manager: FragmentManager)
    : FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Fragment = listFragments[position]

    override fun getPageTitle(position: Int): CharSequence? = list[position]
}