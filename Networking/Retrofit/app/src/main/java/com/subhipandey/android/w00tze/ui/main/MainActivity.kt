
package com.subhipandey.android.w00tze.ui.main

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle



import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.subhipandey.android.w00tze.R
import com.subhipandey.android.w00tze.ui.gists.GistsFragment
import com.subhipandey.android.w00tze.ui.profile.ProfileFragment
import com.subhipandey.android.w00tze.ui.repos.ReposFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

  private val reposFragment = ReposFragment()
  private val gistsFragment = GistsFragment()
  private val profileFragment = ProfileFragment()

  private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    val fragment = when (item.itemId) {
      R.id.navigation_repos -> reposFragment
      R.id.navigation_gists -> gistsFragment
      R.id.navigation_profile -> profileFragment
      else -> ReposFragment()
    }
    switchToFragment(fragment)
    true
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

    switchToFragment(reposFragment)

    checkConnectivity()
  }

  private fun switchToFragment(fragment: Fragment) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.main_container, fragment).commit()
  }

  private fun checkConnectivity() {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    val isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting
    if (!isConnected) {
      Toast.makeText(this, "Check network connection", Toast.LENGTH_SHORT).show()
    }
  }
}
