

package com.subhipandey.android.photosapp.ui.main

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

class NoSwipeViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

  override fun onTouchEvent(event: MotionEvent) = false

  override fun onInterceptTouchEvent(event: MotionEvent) = false
}