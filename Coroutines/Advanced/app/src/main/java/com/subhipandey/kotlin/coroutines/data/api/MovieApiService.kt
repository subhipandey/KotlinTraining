
package com.subhipandey.kotlin.coroutines.data.api

import com.subhipandey.kotlin.coroutines.data.model.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieApiService {

  @GET("/3/movie/popular")
  fun getMovies(@Query("api_key") apiKey: String): Call<MoviesResponse>
}