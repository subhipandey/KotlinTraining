

package com.subhipandey.android.rickycharacters.utils

import android.view.View


fun View.show() : View {
  if (visibility != View.VISIBLE) {
    visibility = View.VISIBLE
  }
  return this
}

fun View.hide() : View {
  if (visibility != View.INVISIBLE) {
    visibility = View.INVISIBLE
  }
  return this
}