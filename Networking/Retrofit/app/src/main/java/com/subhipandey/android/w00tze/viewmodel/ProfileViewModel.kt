

package com.subhipandey.android.w00tze.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.subhipandey.android.w00tze.app.Injection
import com.subhipandey.android.w00tze.model.Either
import com.subhipandey.android.w00tze.model.User
import com.subhipandey.android.w00tze.model.UserRequest


class ProfileViewModel(application: Application) : AndroidViewModel(application) {
  private val repository = Injection.provideRepository()
  private val user = repository.getUser()

  fun getUser() = user

  fun updateUser(company: String): LiveData<Either<User>> {
    val request = UserRequest(company)
    return repository.updateUser(request)
  }
}