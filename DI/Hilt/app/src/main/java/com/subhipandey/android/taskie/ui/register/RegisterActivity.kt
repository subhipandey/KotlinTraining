

package com.subhipandey.android.taskie.ui.register

import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.subhipandey.android.taskie.App
import com.subhipandey.android.taskie.R
import com.subhipandey.android.taskie.model.Success
import com.subhipandey.android.taskie.model.request.UserDataRequest
import com.subhipandey.android.taskie.networking.NetworkStatusChecker
import com.subhipandey.android.taskie.networking.RemoteApi
import com.subhipandey.android.taskie.utils.gone
import com.subhipandey.android.taskie.utils.toast
import com.subhipandey.android.taskie.utils.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

/**
 * Displays the Register screen, with the options to register, or head over to Login!
 */

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

  @Inject
  lateinit var remoteApi: RemoteApi

  private val networkStatusChecker by lazy {
    NetworkStatusChecker(getSystemService(ConnectivityManager::class.java))
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_register)
    initUi()
  }

  private fun initUi() {
    register.setOnClickListener {
      processData(nameInput.text.toString(), emailInput.text.toString(),
        passwordInput.text.toString())
    }
  }

  private fun processData(username: String, email: String, password: String) {
    if (username.isNotBlank() && email.isNotBlank() && password.isNotBlank()) {
      networkStatusChecker.performIfConnectedToInternet {
        remoteApi.registerUser(UserDataRequest(email, password, username)) { result ->
          if (result is Success) {
            toast(result.data)
            onRegisterSuccess()
          } else {
            onRegisterError()
          }
        }
      }
    } else {
      onRegisterError()
    }
  }

  private fun onRegisterSuccess() {
    errorText.gone()
    finish()
  }

  private fun onRegisterError() {
    errorText.visible()
  }
}