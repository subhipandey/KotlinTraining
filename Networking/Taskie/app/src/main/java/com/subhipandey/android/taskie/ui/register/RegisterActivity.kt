
package com.raywenderlich.android.taskie.ui.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.raywenderlich.android.taskie.R
import com.raywenderlich.android.taskie.model.request.UserDataRequest
import com.raywenderlich.android.taskie.networking.RemoteApi
import com.raywenderlich.android.taskie.utils.gone
import com.raywenderlich.android.taskie.utils.toast
import com.raywenderlich.android.taskie.utils.visible
import kotlinx.android.synthetic.main.activity_register.*

/**
 * Displays the Register screen, with the options to register, or head over to Login!
 */
class RegisterActivity : AppCompatActivity() {

  private val remoteApi = RemoteApi()

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
      remoteApi.registerUser(UserDataRequest(email, password, username)) { message, error ->
        if (message != null) {
          toast(message)
          onRegisterSuccess()
        } else if (error != null) {
          onRegisterError()
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