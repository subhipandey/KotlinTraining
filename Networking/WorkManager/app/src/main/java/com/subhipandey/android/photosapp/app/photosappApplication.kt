

package com.subhipandey.android.photosapp.app

import android.app.Application
import android.content.Context


class photosappApplication : Application() {


  companion object {
    private lateinit var instance: photosappApplication

    var isPlayingSong = false

    fun getAppContext(): Context = instance.applicationContext
  }

  override fun onCreate() {
    instance = this
    super.onCreate()
  }
}