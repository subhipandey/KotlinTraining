package com.subhipandey.android.taskie.preferences

interface PreferencesHelper {

  fun saveToken(token: String)

  fun getToken(): String
}