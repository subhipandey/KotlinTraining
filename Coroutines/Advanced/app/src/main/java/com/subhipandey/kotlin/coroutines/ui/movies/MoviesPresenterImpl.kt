
package com.subhipandey.kotlin.coroutines.ui.movies

import com.subhipandey.kotlin.coroutines.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class MoviesPresenterImpl(private val movieRepository: MovieRepository) : MoviesPresenter,
    CoroutineScope {

    private lateinit var moviesView: MoviesView

    override fun setView(moviesView: MoviesView) {
        this.moviesView = moviesView
    }

    override fun getData() {
        launch {
            movieRepository.getMovies(
                onMoviesReceived = { movies -> moviesView.showMovies(movies) },
                onError = { throwable -> handleError(throwable) }
            )
        }
    }

    private fun handleError(throwable: Throwable) {
        moviesView.showError(throwable)
    }

    override val coroutineContext: CoroutineContext
    get() = Dispatchers.Main
}