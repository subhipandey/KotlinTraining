

package com.subhipandey.markme

import android.app.Application
import com.subhipandey.markme.di.applicationModule
import org.koin.android.ext.android.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(applicationModule))
    }
}

