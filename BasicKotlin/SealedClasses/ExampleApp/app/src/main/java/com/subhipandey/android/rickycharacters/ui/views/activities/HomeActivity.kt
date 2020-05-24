

package com.subhipandey.android.rickycharacters.ui.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.subhipandey.android.rickycharacters.R

/**
 * Main Screen
 */
class HomeActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    setTheme(R.style.AppTheme)
    super.onCreate(savedInstanceState)
    setContentView(
        R.layout.activity_home)

    setupNavigation()


  }

  private fun setupNavigation() {
    Navigation.findNavController(this, R.id.navHostFragment)
  }
}
