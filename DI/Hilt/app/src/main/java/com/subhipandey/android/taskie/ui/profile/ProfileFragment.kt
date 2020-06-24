

package com.subhipandey.android.taskie.ui.profile

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.subhipandey.android.taskie.App
import com.subhipandey.android.taskie.R
import com.subhipandey.android.taskie.model.Success
import com.subhipandey.android.taskie.networking.NetworkStatusChecker
import com.subhipandey.android.taskie.ui.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Displays the user profile information.
 */
class ProfileFragment : Fragment() {

  private val remoteApi = App.remoteApi
  private val networkStatusChecker by lazy {
    NetworkStatusChecker(activity?.getSystemService(ConnectivityManager::class.java))
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_profile, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initUi()

    networkStatusChecker.performIfConnectedToInternet {
      GlobalScope.launch(Dispatchers.Main) {
        val result = remoteApi.getUserProfile()

        if (result is Success) {
          userEmail.text = result.data.email
          userName.text = getString(R.string.user_name_text, result.data.name)
          numberOfNotes.text = getString(R.string.number_of_notes_text, result.data.numberOfNotes)
        }
      }
    }
  }

  private fun initUi() {
    logOut.setOnClickListener {
      App.preferences.saveToken("")
      startActivity(Intent(activity, LoginActivity::class.java))
      activity?.finish()
    }
  }
}