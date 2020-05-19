
package com.subhipandey.kotlin.coroutines

import android.app.Application
import com.subhipandey.kotlin.coroutines.di.appModule
import com.subhipandey.kotlin.coroutines.di.networkingModule
import com.subhipandey.kotlin.coroutines.di.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MoviesApp : Application() {

  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidContext(this@MoviesApp)
      modules(listOf(appModule(), networkingModule(), presenterModule()))
    }
  }
}