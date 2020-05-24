

package com.subhipandey.markme.feature.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.subhipandey.markme.R
import com.subhipandey.markme.model.Student
import kotlinx.android.synthetic.main.card_feature_attendance.view.*

class FeatureAttendanceAdapter(val dataList: List<Student>?)
    : RecyclerView.Adapter<FeatureAttendanceAdapter.ViewHolder>(), SpAdapter<Student> {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBoxItem: CheckBox? = itemView.card_feat_attendance__checkbox__student
    }

    override fun getItemCount(): Int = dataList?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewRow = LayoutInflater.from(parent.context).inflate(R.layout.card_feature_attendance, parent, false)
        return ViewHolder(viewRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.checkBoxItem?.apply {
            text = dataList?.let { it[position].name }
            isChecked = dataList?.let { it[position].attendance } ?: false

            setOnClickListener {
                dataList?.get(position)?.attendance = isChecked
            }
        }
    }

    override fun getData(): List<Student>? = dataList

    override fun updateData(data: List<Student>) {
        data.forEach { student ->
            dataList?.first { student.name == it.name }?.attendance = student.attendance
        }
        notifyDataSetChanged()
    }
}
