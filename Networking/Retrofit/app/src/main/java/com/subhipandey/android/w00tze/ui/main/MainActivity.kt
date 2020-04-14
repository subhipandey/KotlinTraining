
package com.subhipandey.android.w00tze.ui.main

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem


import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.BuildConfig
import com.subhipandey.android.w00tze.R
import com.subhipandey.android.w00tze.ui.gists.GistsFragment
import com.subhipandey.android.w00tze.ui.profile.ProfileFragment
import com.subhipandey.android.w00tze.ui.repos.ReposFragment
import com.subhipandey.android.w00tze.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

  private val reposFragment = ReposFragment()
  private val gistsFragment = GistsFragment()
  private val profileFragment = ProfileFragment()

  private lateinit var mainViewModel: MainViewModel

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

    mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

    navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

    switchToFragment(reposFragment)

    checkConnectivity()
  }

  override fun onResume() {
    super.onResume()

    val uri = intent.data
    if (uri != null && uri.toString().startsWith(BuildConfig.REDIRECT_URI)) {
      mainViewModel.getAccessToken(uri) {
        switchToFragment(reposFragment)
      }
    }
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    super.onCreateOptionsMenu(menu)
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.login_menu_item -> startLogin()
      R.id.logout_menu_item -> logout()
    }
    return super.onOptionsItemSelected(item)
  }

  private fun startLogin() {
    if (!mainViewModel.isAuthenticated()) {
      showUsernameDialog {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(
                "https://github.com/login/oauth/authorize?client_id=${BuildConfig.CLIENT_ID}&scope=user%20gist&redirect_uri=${BuildConfig.REDIRECT_URI}"))
        startActivity(intent)
      }
    }
  }

  private fun logout() {
    mainViewModel.logout()
    switchToFragment(reposFragment)
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
