

package com.subhipandey.android.taskie.ui.notes

import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.subhipandey.android.taskie.model.PriorityColor
import com.subhipandey.android.taskie.model.Task
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_task.view.*

/**
 * Holder to display the Task item in a list.
 */
class TaskHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
  LayoutContainer {

  fun bindData(task: Task, onItemLongClick: (String) -> Unit) {
    containerView.setOnLongClickListener {
      onItemLongClick(task.id)
      true
    }

    containerView.taskTitle.text = task.title
    containerView.taskContent.text = task.content

    val drawable = containerView.taskPriority.drawable
    val wrapDrawable = DrawableCompat.wrap(drawable)

    val priorityColor = when (task.taskPriority) {
      1 -> PriorityColor.LOW
      2 -> PriorityColor.MEDIUM
      else -> PriorityColor.HIGH
    }

    DrawableCompat.setTint(wrapDrawable,
      ContextCompat.getColor(containerView.context, priorityColor.getColor()))
  }
}