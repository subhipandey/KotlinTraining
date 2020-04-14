

package com.subhipandey.android.w00tze.app

import com.squareup.picasso.BuildConfig
import com.subhipandey.android.w00tze.model.AuthenticationPrefs
import com.subhipandey.android.w00tze.repository.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.Authenticator


object Injection {
  fun provideRepository(): Repository = RemoteRepository

  private fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
  }

  private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = if (BuildConfig.DEBUG) {
      HttpLoggingInterceptor.Level.BODY
    } else {
      HttpLoggingInterceptor.Level.NONE
    }
    return logging
  }

  private fun provideOkHttpClient(): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
    httpClient.addInterceptor(provideLoggingInterceptor())

    httpClient.addInterceptor { chain ->
      val request = chain.request().newBuilder().addHeader("Authorization", "token ${AuthenticationPrefs.getAuthToken()}").build()
      chain.proceed(request)
    }

    return httpClient.build()
  }

  fun provideGitHubApi(): GitHubApi {
    return provideRetrofit().create(GitHubApi::class.java)
  }

  private fun provideAuthRetrofit(): Retrofit {
    return Retrofit.Builder()
            .baseUrl("https://github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
  }

  fun provideAuthApi(): AuthApi {
    return provideAuthRetrofit().create(AuthApi::class.java)
  }
}