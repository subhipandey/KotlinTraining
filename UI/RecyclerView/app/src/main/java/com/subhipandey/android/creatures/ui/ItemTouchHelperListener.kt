package com.subhipandey.android.creatures.ui

import android.support.v7.widget.RecyclerView
import java.text.FieldPosition

interface ItemTouchHelperListener {
    fun onItemMove(recyclerView: RecyclerView, fromPosition: Int, toPosition: Int): Boolean
    fun onItemDismiss(viewHolder: RecyclerView.ViewHolder, position: Int )
}