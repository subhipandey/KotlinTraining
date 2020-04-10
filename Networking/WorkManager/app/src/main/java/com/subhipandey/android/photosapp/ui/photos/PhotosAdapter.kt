

package com.subhipandey.android.photosapp.ui.photos

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.subhipandey.android.photosapp.R
import com.subhipandey.android.photosapp.app.inflate
import com.squareup.picasso.Picasso


class PhotosAdapter(private val photos: List<String>) : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(parent.inflate(R.layout.list_item_photo))
  }

  override fun getItemCount() = photos.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(photos[position])
  }

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val photoImageView: ImageView = itemView.findViewById(R.id.photo)

    fun bind(photo: String) {
      Picasso.get().load(photo).into(photoImageView)
    }
  }
}