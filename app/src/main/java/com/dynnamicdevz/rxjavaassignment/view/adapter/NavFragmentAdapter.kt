package com.dynnamicdevz.rxjavaassignment.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dynnamicdevz.rxjavaassignment.view.fragment.GridRepoFragment
import com.dynnamicdevz.rxjavaassignment.view.fragment.ListRepoFragment

class NavFragmentAdapter(fm: FragmentManager): FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return when(position){
            0->ListRepoFragment()
            else->GridRepoFragment()
        }
    }
}