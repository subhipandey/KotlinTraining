package com.subhipandey.android.animaldoppelganger

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DoppelAdapter(activity: AppCompatActivity, val itemsCount: Int) :
        FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {

        return itemCount

    }

    override fun createFragment(position: Int): Fragment {
     return DoppelgangerFragment.getInstance(position)
    }
}