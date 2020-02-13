package com.example.listmaker

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter : RecyclerView.Adapter<TodoListViewHolder>() {

    private val todoLists = arrayOf("Android Developers", "House Work", "Errands", "Shopping")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_list_view_holder, parent, false)
        return TodoListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoLists.size
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {

        holder.listPositionTextView.text = (position + 1).toString()
        holder.listTitleTextView.text = todoLists[position]

    }
}