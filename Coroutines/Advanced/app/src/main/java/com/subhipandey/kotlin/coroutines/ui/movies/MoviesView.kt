
package com.subhipandey.kotlin.coroutines.ui.movies

import com.subhipandey.kotlin.coroutines.data.model.Movie


interface MoviesView {

  fun showMovies(movies: List<Movie>)

  fun showError(throwable: Throwable)
}