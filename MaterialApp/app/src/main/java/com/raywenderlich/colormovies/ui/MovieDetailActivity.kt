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

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.raywenderlich.colormovies.R
import com.raywenderlich.colormovies.data.api.RetrofitClient
import com.raywenderlich.colormovies.utils.CropSquareTransformation
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.BlurTransformation
import jp.wasabeef.picasso.transformations.GrayscaleTransformation
import kotlinx.android.synthetic.main.activity_movie_list.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import kotlin.math.roundToInt

class MovieDetailActivity : AppCompatActivity() {

  private val picasso = Picasso.get()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_movie_list)
    configureUI()
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.main_menu, menu)

    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.grayscale -> setGrayScale()
      R.id.cropCircle -> setCropSquareTransformation()
      R.id.blur -> setBlurFilter()
      else -> toast("error")
    }
    return super.onOptionsItemSelected(item)
  }

  private fun setBlurFilter() {
    picasso
        .load(RetrofitClient.TMDB_IMAGEURL + intent.getStringExtra(MainActivity.POSTER))
        .transform(BlurTransformation(this))
        .error(R.drawable.iconfinder_movie_285656)
        .into(detailImageView)
  }

  private fun setGrayScale() {
    picasso
        .load(RetrofitClient.TMDB_IMAGEURL + intent.getStringExtra(MainActivity.POSTER))
        .transform(GrayscaleTransformation())
        .error(R.drawable.iconfinder_movie_285656)
        .into(detailImageView)
  }

  private fun setCropSquareTransformation() {
    picasso
        .load(RetrofitClient.TMDB_IMAGEURL + intent.getStringExtra(MainActivity.POSTER))
        .transform(CropSquareTransformation())
        .error(R.drawable.iconfinder_movie_285656)
        .into(detailImageView)
  }

  private fun configureUI() {
    titleDetailTextView.text = intent.getStringExtra(MainActivity.TITLE)
    summaryDetailTextView.text = intent.getStringExtra(MainActivity.SUMMARY)
    releaseDateTextView.text = intent.getStringExtra(MainActivity.RELEASE_DATE)
    ratingTextView.text = String.format(getString(R.string.rating), intent.getFloatExtra(MainActivity.RATING, 1f).roundToInt())
    picasso
        .load(RetrofitClient.TMDB_IMAGEURL + intent.getStringExtra(MainActivity.POSTER))
        .error(R.drawable.iconfinder_movie_285656)
        .into(detailImageView)
  }

}
