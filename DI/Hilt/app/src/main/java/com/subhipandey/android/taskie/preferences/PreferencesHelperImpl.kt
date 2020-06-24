package com.subhipandey.android.taskie.preferences

import android.content.SharedPreferences

const val KEY_TOKEN = "token"

class PreferencesHelperImpl(private val preference: SharedPreferences) : PreferencesHelper {

  override fun saveToken(token: String) {
    preference.edit()
      .putString(KEY_TOKEN, token)
      .apply()
  }

  override fun getToken() = preference.getString(KEY_TOKEN, "") ?: ""
}