package com.subhipandey.android.creatures.ui

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class SpacingItemDecoration(private val spanCount: Int, private val spacing: Int ) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        outRect.top = spacing/ 2
        outRect.bottom = spacing / 2
        outRect.left = spacing / 2
        outRect.right = spacing / 2

        if (position < spanCount) {
            outRect.top = spacing
        }
        if (position < spanCount) {
            outRect.left = spacing
        }
        if (position < spanCount) {
            outRect.right = spacing
        }

    }
}