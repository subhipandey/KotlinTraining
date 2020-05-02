package com.subhipandey.android.cryptome.adapters

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.subhipandey.android.cryptome.fragments.BaseFragment
import com.subhipandey.android.cryptome.fragments.HomeFragment
import com.subhipandey.android.cryptome.fragments.SecondFragment

class FragmentAdapter(fm: FragmentManager, private var totalTabs: Int) : FragmentPagerAdapter(fm) {

  override fun getItem(position: Int): BaseFragment {
    when (position) {
      0 -> {
        return HomeFragment.newInstance("USD,CAD,EUR,BRL")
      }
      1 -> {
        return SecondFragment.newInstance("USD,CAD,EUR,BRL")
      }
    }

    return BaseFragment()
  }

  override fun getCount(): Int {
    return totalTabs
  }
}