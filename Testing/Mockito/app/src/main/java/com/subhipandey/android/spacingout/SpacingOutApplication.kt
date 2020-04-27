

package com.subhipandey.android.spacingout

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class SpacingOutApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    AndroidThreeTen.init(this)
  }
}