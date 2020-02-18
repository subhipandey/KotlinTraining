package com.example.listmaker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TaskListAdapter(var list: TaskList) : RecyclerView.Adapter<TaskListView>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListView {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.task_view_holder,parent, false)
        return TaskListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.tasks.size
    }

    override fun onBindViewHolder(holder: TaskListView, position: Int) {
        holder.taskTextView?.text = list.tasks[position]
    }
}