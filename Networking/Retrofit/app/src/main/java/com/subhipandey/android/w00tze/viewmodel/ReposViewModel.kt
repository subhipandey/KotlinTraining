
package com.subhipandey.android.w00tze.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.subhipandey.android.w00tze.app.Injection


class ReposViewModel(application: Application) : AndroidViewModel(application) {
  private val repository = Injection.provideRepository()
  private val allRepos = repository.getRepos()

  fun getRepos() = allRepos
}