

package com.subhipandey.android.w00tze.app

import com.squareup.picasso.BuildConfig
import com.subhipandey.android.w00tze.repository.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Injection {
  fun provideRepository(): Repository = RemoteRepository

  private fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
  }

  private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = if(BuildConfig.DEBUG){
      HttpLoggingInterceptor.Level.BODY
    } else {
      HttpLoggingInterceptor.Level.NONE
    }
    return logging
  }
  private fun provideOkHttpClient(): OkHttpClient{
    val httpClient = OkHttpClient.Builder()
    httpClient.addInterceptor(provideLoggingInterceptor())
    return httpClient.build()
  }
  fun provideGithubApi(): GitHubApi{
    return provideRetrofit().create(GitHubApi::class.java)
  }
}