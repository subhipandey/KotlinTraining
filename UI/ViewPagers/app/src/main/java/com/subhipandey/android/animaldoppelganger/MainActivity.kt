
package com.subhipandey.android.animaldoppelganger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Main Screen
 */
class MainActivity : AppCompatActivity() {

  private lateinit var doppelgangerNamesArray: Array<String>

  //TODO:4 Define page change callback here

  override fun onCreate(savedInstanceState: Bundle?) {
    // Switch to AppTheme for displaying the activity
    setTheme(R.style.AppTheme)

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    doppelgangerNamesArray = resources.getStringArray(R.array.doppelganger_names)


  override fun onDestroy() {
    super.onDestroy()
  }
}
