
package com.subhipandey.android.octomembers.ui.teammembers

import com.subhipandey.android.octomembers.model.Member


interface TeamMembersContract {

  interface View {
    fun showMembers(members: List<Member>)
    fun showErrorRetrievingMembers()
    fun clearMembers()
    fun showLoading()
    fun hideLoading()
    fun disableInput()
    fun enableInput()
    fun showEmptyState()
    fun hideEmptyState()
    fun hideMembers()
  }

  interface Presenter {
    fun retrieveAllMembers(teamName: String)

  }
}