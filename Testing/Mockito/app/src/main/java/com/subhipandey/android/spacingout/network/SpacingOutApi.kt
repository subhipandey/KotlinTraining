

package com.subhipandey.android.spacingout.network

import com.subhipandey.android.spacingout.models.ApodImage
import com.subhipandey.android.spacingout.models.EarthImage
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SpacingOutApi {
  companion object {
    fun create(): SpacingOutApi {
      val client = OkHttpClient.Builder().addInterceptor { chain ->
        val url = chain.request().url().newBuilder().addQueryParameter("api_key", "IaZbUHgLeD5G3evuRL0ZDlaAXP9bIVPU919Gt9CF").build()
        val request = chain.request().newBuilder().url(url).build()
        chain.proceed(request)
      }.build()
      return Retrofit.Builder()
          .addConverterFactory(MoshiConverterFactory.create())
          .baseUrl("https://api.nasa.gov")
          .client(client)
          .build()
          .create(SpacingOutApi::class.java)
    }
  }

  @GET("/planetary/apod")
  suspend fun getImage(@Query("date") date: String): ApodImage

  @GET("/planetary/earth/imagery/")
  suspend fun getEarthImagery(@Query("lon") longitude: Float, @Query("lat") latitude: Float): EarthImage
}