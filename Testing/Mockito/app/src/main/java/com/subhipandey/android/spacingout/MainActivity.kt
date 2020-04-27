

package com.subhipandey.android.spacingout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.subhipandey.android.spacingout.images.ImagesFragment
import com.subhipandey.android.spacingout.lookup.LookupFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val images = ImagesFragment()
    supportFragmentManager.beginTransaction().replace(R.id.content, images).commit()
    nav_view.setOnNavigationItemSelectedListener { menuItem ->
      when (menuItem.itemId) {
        R.id.images -> {
          supportFragmentManager.beginTransaction().replace(R.id.content, images).commit()
        }
        R.id.lookup -> {
          val lookup = LookupFragment()
          supportFragmentManager.beginTransaction().replace(R.id.content, lookup).commit()
        }
      }
      true
    }
  }
}
