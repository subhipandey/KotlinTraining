package com.subhipandey.android.creatures.ui

import android.graphics.Canvas
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.text.style.LineHeightSpan

class DividerItemDecoration(color: Int,private val heightInPixels: Int): RecyclerView.ItemDecoration() {
    private val paint = Paint()
    init {
        paint.color = color
        paint.isAntiAlias = true

    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for(i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + heightInPixels

            c.drawRect(left.toFloat() , top.toFloat(), right.toFloat(), bottom.toFloat(), paint)
        }
    }

}