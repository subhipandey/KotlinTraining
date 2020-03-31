package com.subhipandey.android.creatures.ui

import android.graphics.Canvas
import android.graphics.Paint
import android.support.v7.widget.RecyclerView

class FoodItemDecoration(color: Int, private val dividerWidthInPixels: Int): RecyclerView.ItemDecoration() {
    private val paint = Paint()
    init {
        paint.color = color
        paint.isAntiAlias = true

    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)


        val childCount = parent.childCount
        for(i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams


            var left = parent.paddingLeft
            var right = parent.width - parent.paddingRight
            var top = child.top + params.topMargin
            var bottom = top + dividerWidthInPixels

            c.drawRect(left.toFloat() , top.toFloat(), right.toFloat(), bottom.toFloat(), paint)

            left = child.right - params.rightMargin
            right = left + dividerWidthInPixels
            top = parent.paddingTop
            bottom = parent.height - parent.paddingBottom
            c.drawRect(left.toFloat() , top.toFloat(), right.toFloat(), bottom.toFloat(), paint)
        }
    }

}