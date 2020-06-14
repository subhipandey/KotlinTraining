

package com.subhipandey.android.potterverse

import android.app.Application

open class PotterApp : Application() {
  open fun getBaseUrl() = "https://www.potterapi.com"
}