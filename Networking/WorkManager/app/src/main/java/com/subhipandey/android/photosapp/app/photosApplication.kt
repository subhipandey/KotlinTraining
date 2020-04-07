

package com.subhipandey.android.photosapp.app

import android.app.Application
import android.content.Context


class photosApplication : Application() {

  companion object {
    private lateinit var instance: photosApplication

    fun getAppContext(): Context = instance.applicationContext
  }

  override fun onCreate() {
    instance = this
    super.onCreate()
  }
}