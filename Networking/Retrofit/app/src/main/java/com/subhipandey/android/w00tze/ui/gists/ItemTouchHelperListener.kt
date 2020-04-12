

package com.subhipandey.android.w00tze.ui.gists
import androidx.recyclerview.widget.RecyclerView


interface ItemTouchHelperListener {
  fun onItemDismiss(viewHolder: RecyclerView.ViewHolder, position: Int)
}