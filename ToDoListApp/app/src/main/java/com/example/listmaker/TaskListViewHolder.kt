package com.example.listmaker

import android.view.View
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class TaskListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val taskTextView = itemView?.findViewById<TextView>(R.id.textview_task) as TextView
