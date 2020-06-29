package com.subhipandey.android.animaldoppelganger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator

/**
 * Main Screen
 */
class MainActivity : AppCompatActivity() {

    private lateinit var doppelgangerNamesArray: Array<String>

    var doppelgangerPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            Toast.makeText(this@MainActivity, "Selected position: ${position}",
                    Toast.LENGTH_SHORT).show()


        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // Switch to AppTheme for displaying the activity
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doppelgangerNamesArray = resources.getStringArray(R.array.doppelganger_names)

        val doppelAdapter = DoppelAdapter(this, doppelgangerNamesArray.size)
        doppelgangerViewPager.adapter = doppelAdapter


        doppelgangerViewPager.registerOnPageChangeCallback(doppelgangerPageChangeCallback)

        TabLayoutMediator(tabLayout, doppelgangerViewPager){tab, position ->
            tab.text = doppelgangerNamesArray[position].split("")[0]

        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        doppelgangerViewPager.unregisterOnPageChangeCallback(doppelgangerPageChangeCallback)
    }


}
