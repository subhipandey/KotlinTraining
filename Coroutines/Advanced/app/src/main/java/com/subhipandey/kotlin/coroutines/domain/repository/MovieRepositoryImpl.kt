
package com.subhipandey.kotlin.coroutines.domain.repository

import com.subhipandey.kotlin.coroutines.data.api.MovieApiService
import com.subhipandey.kotlin.coroutines.data.database.MovieDao
import com.subhipandey.kotlin.coroutines.di.API_KEY
import com.subhipandey.kotlin.coroutines.data.model.Movie
import com.subhipandey.kotlin.coroutines.data.model.MoviesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class MovieRepositoryImpl(
  private val movieApiService: MovieApiService,
  private val movieDao: MovieDao
) : MovieRepository {

  override suspend fun getMovies(): Result<List<Movie>> = withContext(Dispatchers.IO) {

    val cachedMovies = movieDao.getSavedMovies()

    try {
      val result = movieApiService.getMovies(API_KEY).execute()
      val moviesResponse = result.body()?.movies

      if (result.isSuccessful && moviesResponse != null) {
        Result(moviesResponse, null)
      } else {
        Result(cachedMovies, null)
      }
    } catch (error: Throwable) {
      if (error is IOException && cachedMovies.isEmpty()) {
        Result(null, error)
      } else {
        Result(cachedMovies, null)
      }
    }
  }
}