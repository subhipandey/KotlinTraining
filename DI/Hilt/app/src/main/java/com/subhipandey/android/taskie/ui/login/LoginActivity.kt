
package com.subhipandey.android.taskie.ui.login

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.subhipandey.android.taskie.App
import com.subhipandey.android.taskie.R
import com.subhipandey.android.taskie.model.Success
import com.subhipandey.android.taskie.model.request.UserDataRequest
import com.subhipandey.android.taskie.networking.NetworkStatusChecker
import com.subhipandey.android.taskie.networking.RemoteApi
import com.subhipandey.android.taskie.preferences.PreferencesHelper
import com.subhipandey.android.taskie.ui.main.MainActivity
import com.subhipandey.android.taskie.ui.register.RegisterActivity
import com.subhipandey.android.taskie.utils.gone
import com.subhipandey.android.taskie.utils.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

/**
 * Displays the Login screen, with the options to head over to the Register screen.
 */

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

  @Inject
  lateinit var remoteApi : RemoteApi

  @Inject
  lateinit var preferencesHelper: PreferencesHelper
  private val networkStatusChecker by lazy {
    NetworkStatusChecker(getSystemService(ConnectivityManager::class.java))
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)
    initUi()

    if (preferencesHelper.getToken().isNotBlank()) {
      startActivity(MainActivity.getIntent(this))
    }
  }

  private fun initUi() {
    login.setOnClickListener {
      val email = emailInput.text.toString()
      val password = passwordInput.text.toString()

      if (email.isNotBlank() && password.isNotBlank()) {
        logUserIn(UserDataRequest(email, password))
      } else {
        showLoginError()
      }
    }
    register.setOnClickListener { startActivity(Intent(this, RegisterActivity::class.java)) }
  }

  private fun logUserIn(userDataRequest: UserDataRequest) {
    networkStatusChecker.performIfConnectedToInternet {
      remoteApi.loginUser(userDataRequest) { result ->
        if (result is Success) {
          onLoginSuccess(result.data)
        } else {
          showLoginError()
        }
      }
    }
  }

  private fun onLoginSuccess(token: String) {
    errorText.gone()
    preferencesHelper.saveToken(token)
    startActivity(MainActivity.getIntent(this))
  }

  private fun showLoginError() {
    errorText.visible()
  }
}