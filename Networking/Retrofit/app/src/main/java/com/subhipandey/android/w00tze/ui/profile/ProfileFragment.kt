

package com.subhipandey.android.w00tze.ui.profile


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.subhipandey.android.w00tze.R
import com.subhipandey.android.w00tze.model.User
import com.subhipandey.android.w00tze.viewmodel.ProfileViewModel
import com.squareup.picasso.Picasso
import com.subhipandey.android.w00tze.model.ApiError
import com.subhipandey.android.w00tze.model.Either
import com.subhipandey.android.w00tze.model.Status
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileViewModel.getUser().observe(this, observer)

        val onClickListener = View.OnClickListener {
            showCompanyDialog(company.text.toString()) { newCompany ->
                profileViewModel.updateUser(newCompany).observe(this, observer)
            }
        }

        login.setOnClickListener(onClickListener)
        company.setOnClickListener(onClickListener)
    }

    private val observer = Observer<Either<User>> { either ->
        if (either?.status == Status.SUCCESS && either.data != null) {
            val user = either.data
            login.text = String.format(getString(R.string.screen_name_format), user.login)
            repoName.text = user.name
            company.text = user.company
            Picasso.with(context).load(user.avatarUrl).into(avatar)
        } else {
            if (either?.error == ApiError.USER) {
                Toast.makeText(context, getString(R.string.error_retrieving_user), Toast.LENGTH_SHORT).show()
            }
        }
    }
}