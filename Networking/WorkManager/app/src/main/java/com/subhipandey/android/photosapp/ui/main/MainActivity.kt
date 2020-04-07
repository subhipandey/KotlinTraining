

package com.subhipandey.android.photosapp.ui.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.subhipandey.android.photosapp.R
import com.subhipandey.android.photosapp.ui.photos.PhotosFragment
import com.subhipandey.android.photosapp.ui.song.SongFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setupNavigation()
    setupViewPager()
  }

  private fun setupNavigation() {
    navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
  }

  private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    when (item.itemId) {
      R.id.navigation_photos -> {
        title = getString(R.string.app_name)
        viewPager.setCurrentItem(0, false)
        return@OnNavigationItemSelectedListener true
      }
      R.id.navigation_song -> {
        title = getString(R.string.app_name)
        viewPager.setCurrentItem(1, false)
        return@OnNavigationItemSelectedListener true
      }
    }
    false
  }

  private fun setupViewPager() {
    viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
      override fun getItem(position: Int): Fragment? {
        when (position) {
          0 -> return PhotosFragment.newInstance()
          1 -> return SongFragment.newInstance()
        }
        return null
      }

      override fun getCount() = 2
    }
  }
}
