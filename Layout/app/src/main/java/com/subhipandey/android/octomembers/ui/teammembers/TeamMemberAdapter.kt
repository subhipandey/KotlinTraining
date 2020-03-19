

package com.subhipandey.android.octomembers.ui.teammembers


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.subhipandey.android.octomembers.R
import com.subhipandey.android.octomembers.model.Member
import com.subhipandey.android.octomembers.ui.member.MemberActivity
import kotlinx.android.synthetic.main.list_item_team_member_new.view.*

class TeamMemberAdapter(var members: List<Member>) : RecyclerView.Adapter<TeamMemberAdapter.TeamMemberViewHolder>() {

  override fun onBindViewHolder(holder: TeamMemberViewHolder, position: Int) = holder.bind(members[position])

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamMemberViewHolder {
    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_team_member_new, parent, false)
    return TeamMemberViewHolder(itemView)
  }

  override fun getItemCount() = members.size

  inner class TeamMemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    lateinit var member: Member

    init {
      itemView.setOnClickListener(this)
    }

    fun bind(member: Member) {
      this.member = member
      itemView.teamMemberType.text = member.login
      Picasso.get().load(member.avatarUrl).into(itemView.teamMemberAvatar)
      itemView.teamMemberType.text = member.type
    }

    override fun onClick(view: View) {
      val context = view.context
      val intent = MemberActivity.newIntent(context, member.login)
      context.startActivity(intent)
    }
  }
}