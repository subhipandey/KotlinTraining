

package com.subhipandey.android.datadrop.ui.droplist

import android.support.v7.widget.RecyclerView


interface ItemTouchHelperListener {
  fun onItemDismiss(viewHolder: RecyclerView.ViewHolder, position: Int)
}