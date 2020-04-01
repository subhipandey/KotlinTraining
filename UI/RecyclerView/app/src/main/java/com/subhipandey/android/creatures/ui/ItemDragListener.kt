package com.subhipandey.android.creatures.ui

import android.support.v7.widget.RecyclerView

interface ItemDragListener {
    fun onItemDrag(viewHolder: RecyclerView.ViewHolder)
}