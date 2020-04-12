

package com.subhipandey.android.w00tze.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import androidx.lifecycle.AndroidViewModel
import com.subhipandey.android.w00tze.app.Injection


class ProfileViewModel(application: Application) : AndroidViewModel(application) {
  private val repository = Injection.provideRepository()
  private val user = repository.getUser()

  fun getUser() = user
}