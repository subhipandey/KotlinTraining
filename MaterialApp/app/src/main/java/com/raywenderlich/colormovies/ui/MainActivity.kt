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

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.raywenderlich.colormovies.R
import com.raywenderlich.colormovies.data.MovieInteractor
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast

class MainActivity : AppCompatActivity() {

  companion object {
    const val TITLE = "TITLE"
    const val SUMMARY = "SUMMARY"
    const val POSTER = "POSTER"
    const val RELEASE_DATE = "RELEASE_DATE"
    const val RATING = "RATING"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    movieRecyclerView.layoutManager = GridLayoutManager(this, 2)
    MovieInteractor().getPopularMovies().observe(this, Observer { movieList ->
      if (movieList != null) {
        val adapter = MovieAdapter(movieList, windowManager) { movie ->
          startActivity(
              Intent(this@MainActivity, MovieDetailActivity::class.java)
                  .putExtra(TITLE, movie?.title)
                  .putExtra(SUMMARY, movie?.overview)
                  .putExtra(POSTER, movie?.posterPath)
                  .putExtra(RELEASE_DATE, movie?.releaseDate)
                  .putExtra(RATING, movie?.popularity)
          )
        }
        movieRecyclerView.adapter = adapter
      } else {
        longToast("No movies")
      }
    })
  }
}
