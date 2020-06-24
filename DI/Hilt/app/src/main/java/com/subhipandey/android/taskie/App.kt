

package com.subhipandey.android.taskie

import android.app.Application
import android.content.Context
import com.subhipandey.android.taskie.di.KEY_PREFERENCES
import com.subhipandey.android.taskie.networking.buildRemoteApi
import com.subhipandey.android.taskie.preferences.PreferencesHelperImpl
import dagger.hilt.android.HiltAndroidApp



@HiltAndroidApp
class App : Application()