

package com.subhipandey.android.spacingout.images

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.subhipandey.android.spacingout.models.ApodImage
import kotlinx.android.synthetic.main.adapter_images_item.view.*

class ImagesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
  fun bind(image: ApodImage) {
    val drawable = CircularProgressDrawable(itemView.context).apply {
      strokeWidth = 5f
      centerRadius = 30f
      start()
    }
    Glide.with(itemView).load(image.url).placeholder(drawable).into(itemView.image)
    itemView.text.text = image.explanation
  }
}