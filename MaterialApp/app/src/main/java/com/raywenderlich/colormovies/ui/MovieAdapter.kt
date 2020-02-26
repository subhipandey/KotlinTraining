/*
 *
 * Copyright (c) 2019 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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