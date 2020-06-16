

package com.subhipandey.android.taskie.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.subhipandey.android.taskie.App
import com.subhipandey.android.taskie.R
import com.subhipandey.android.taskie.networking.RemoteApi
import com.subhipandey.android.taskie.ui.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * Displays the user profile information.
 */
class ProfileFragment : Fragment() {

  private val remoteApi = RemoteApi()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_profile, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initUi()

    remoteApi.getUserProfile { userProfile, _ ->
      if (userProfile != null) {
        userEmail.text = userProfile.email
        userName.text = getString(R.string.user_name_text, userProfile.name)
        numberOfNotes.text = getString(R.string.number_of_notes_text, userProfile.numberOfNotes)
      }
    }
  }

  private fun initUi() {
    logOut.setOnClickListener {
      App.saveToken("")
      startActivity(Intent(activity, LoginActivity::class.java))
      activity?.finish()
    }
  }
}