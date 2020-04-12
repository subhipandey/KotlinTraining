

package com.subhipandey.android.w00tze.ui.gists

import android.support.v7.util.DiffUtil
import androidx.recyclerview.widget.DiffUtil
import com.subhipandey.android.w00tze.model.Gist


class GistDiffCallback(private val oldGists: List<Gist>,
                       private val newGists: List<Gist>) : DiffUtil.Callback() {

  override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//    return oldGists[oldItemPosition].id == newGists[newItemPosition].id // TODO: uncomment
    return false
  }

  override fun getOldListSize() = oldGists.size


  override fun getNewListSize() = newGists.size


  override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    val oldGist = oldGists[oldItemPosition]
    val newGist = newGists[newItemPosition]

    return oldGist == newGist
  }
}
