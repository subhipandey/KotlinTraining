

package com.subhipandey.android.animaldoppelganger

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_VERTICAL
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Main Screen
 */
class MainActivity : AppCompatActivity() {

  private lateinit var doppelgangerNamesArray: Array<String>


  private var doppelgangerPageChangeCallback = object : OnPageChangeCallback() {
    override fun onPageSelected(position: Int) {
      Toast.makeText(this@MainActivity,
          "Selected position: $position",
          Toast.LENGTH_SHORT).show()
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    // Switch to AppTheme for displaying the activity
    setTheme(R.style.AppTheme)

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    doppelgangerNamesArray = resources.getStringArray(R.array.doppelganger_names)


    val doppelgangerAdapter = DoppelgangerAdapter(this, doppelgangerNamesArray.size)
    doppelgangerViewPager.adapter = doppelgangerAdapter


    doppelgangerViewPager.registerOnPageChangeCallback(doppelgangerPageChangeCallback)


   doppelgangerViewPager.orientation = ORIENTATION_VERTICAL


      TabLayoutMediator(tabLayout, doppelgangerViewPager) { tab, position ->

          tab.text = doppelgangerNamesArray[position].split(" ")[0]
      }.attach()


    doppelgangerViewPager.layoutDirection = ViewPager2.LAYOUT_DIRECTION_RTL
    tabLayout.layoutDirection = View.LAYOUT_DIRECTION_RTL
  }

  override fun onDestroy() {
    super.onDestroy()

    doppelgangerViewPager.unregisterOnPageChangeCallback(doppelgangerPageChangeCallback)
  }
}
