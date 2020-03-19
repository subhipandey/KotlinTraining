

package com.subhipandey.android.octomembers.ui.member

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.subhipandey.android.octomembers.R
import com.subhipandey.android.octomembers.model.Member
import com.subhipandey.android.octomembers.repository.remote.RemoteRepository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_member.*


class MemberActivity : AppCompatActivity(), MemberContract.View {

  lateinit var presenter: MemberContract.Presenter

  companion object {
    const val EXTRA_MEMBER_LOGIN = "EXTRA_MEMBER_LOGIN"

    fun newIntent(context: Context, memberLogin: String): Intent {
      val intent = Intent(context, MemberActivity::class.java)
      intent.putExtra(EXTRA_MEMBER_LOGIN, memberLogin)
      return intent
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_member)

    setupPresenter()
    setupActionBar()

    presenter.retrieveMember(memberLoginFromIntent())
  }

  private fun setupPresenter() {
    presenter = MemberPresenter(RemoteRepository(), this)
  }

  private fun setupActionBar() {
    title = memberLoginFromIntent()
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
  }

  private fun showMemberName(member: Member) {
    if (member.name != null && member.name.isNotEmpty()) {
      memberName.text = member.name
    } else {
      memberName.visibility = View.GONE
    }
  }

  private fun showStringInFieldOrGone(string: String?, textView: TextView, labelTextView: TextView) {
    if (string != null && string.isNotEmpty()) {
      textView.text = string
      textView.visibility = View.VISIBLE
      labelTextView.visibility = View.VISIBLE
    } else {
      textView.visibility = View.GONE
      labelTextView.visibility = View.GONE
    }
  }

  private fun showMemberInfo(member: Member) {
    showStringInFieldOrGone(member.login, memberLogin, labelLogin)
    showStringInFieldOrGone(member.company, memberCompany, labelCompany)
    showStringInFieldOrGone(member.email, memberEmail, labelEmail)
    showStringInFieldOrGone(member.type, memberType, labelType)
  }


  private fun memberLoginFromIntent() = intent.getStringExtra(EXTRA_MEMBER_LOGIN)

  override fun showMember(member: Member) {
    Picasso.get().load(member.avatarUrl).into(memberAvatar)
    showMemberName(member)
    showMemberInfo(member)
  }

  override fun showErrorRetrievingMember() {
    Toast.makeText(this, getString(R.string.error_retrieving_member), Toast.LENGTH_SHORT).show()
  }
}
