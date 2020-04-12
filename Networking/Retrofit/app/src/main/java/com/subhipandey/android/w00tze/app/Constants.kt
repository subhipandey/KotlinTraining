

package com.subhipandey.android.w00tze.app


object Constants {

  private const val BASE_URL = "https://api.github.com"

  fun fullUrlString(path: String) = "$BASE_URL$path"
}