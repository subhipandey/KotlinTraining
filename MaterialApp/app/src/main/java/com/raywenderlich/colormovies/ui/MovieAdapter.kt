/*
 *

 */

package com.raywenderlich.colormovies.ui

import android.graphics.Point
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.raywenderlich.colormovies.R
import com.raywenderlich.colormovies.data.api.RetrofitClient
import com.raywenderlich.colormovies.data.model.Movie
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*
import kotlin.math.roundToInt


class MovieAdapter(
    val movieList: List<Movie>,
    val windowManager: WindowManager,
    var listener: (Movie?) -> Unit
) : Adapter<MovieAdapter.ViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
    return ViewHolder(view)
  }

  override fun getItemCount() = movieList.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(movieList[position])
  }

  inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(movie: Movie) = with(view) {
      //titleTextView.text = movie.originalTitle
      view.setOnClickListener { listener(movie) }
      val display = windowManager.defaultDisplay
      val size = Point()
      display.getSize(size)
      val width = (size.x) / 2
      val height = ((size.y) / 2.2).roundToInt()
      val picasso = Picasso.get()
      if (movie.posterPath != null) {
        picasso.load(RetrofitClient.TMDB_IMAGEURL + movie.posterPath)
            .placeholder(R.drawable.iconfinder_movie_285656)
            .resize(width, height)
            .into(posterImageView)
      } else {
        picasso.load(R.drawable.iconfinder_movie_285656)
            .noFade()
            .resize(width, height)
            .into(posterImageView)
      }
    }
  }
}