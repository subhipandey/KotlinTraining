

package com.subhipandey.android.w00tze.ui.gists


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subhipandey.android.w00tze.R
import com.subhipandey.android.w00tze.app.inflate
import com.subhipandey.android.w00tze.model.Gist
import kotlinx.android.synthetic.main.list_item_gist.view.*
import java.text.SimpleDateFormat
import java.util.*


class GistAdapter(private val gists: MutableList<Gist>, private val listener: GistAdapterListener)
  : RecyclerView.Adapter<GistAdapter.ViewHolder>(), ItemTouchHelperListener {

  companion object{
private val DATE_FORMATTER = SimpleDateFormat("EEE M/dd/yyyy hh:mm a", Locale.US)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(parent.inflate(R.layout.list_item_gist))
  }

  override fun getItemCount() = gists.size

  fun updateGists(gists: List<Gist>) {
    this.gists.clear()
    this.gists.addAll(gists)
    notifyDataSetChanged()
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(gists[position])
  }

  override fun onItemDismiss(viewHolder: RecyclerView.ViewHolder, position: Int) {
    listener.deleteGist(gists[position])
  }

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var gist: Gist

    fun bind(gist: Gist) {
      this.gist = gist
      itemView.gistDescription.text = gist.description
      itemView.gistCreatedAt.text = DATE_FORMATTER.format(gist.createdAt)
    }
  }

  interface GistAdapterListener {
    fun deleteGist(gist: Gist)
  }
}