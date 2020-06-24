
package com.subhipandey.android.taskie.networking

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.subhipandey.android.taskie.App
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

private const val HEADER_AUTHORIZATION = "Authorization"
private const val BASE_URL = "https://taskie-rw.herokuapp.com"

fun buildClient(): OkHttpClient =
  OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.BODY
    })
    .addInterceptor(buildAuthorizationInterceptor())
    .build()

fun buildAuthorizationInterceptor() = object : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val originalRequest = chain.request()

    if (App.preferences.getToken().isBlank()) return chain.proceed(originalRequest)

    val new = originalRequest.newBuilder()
      .addHeader(HEADER_AUTHORIZATION, App.preferences.getToken())
      .build()

    return chain.proceed(new)
  }
}

fun buildRetrofit(): Retrofit {
  val contentType = "application/json".toMediaType()

  return Retrofit.Builder()
    .client(buildClient())
    .baseUrl(BASE_URL)
    .addConverterFactory(Json.nonstrict.asConverterFactory(contentType))
    .build()
}

fun buildApiService(): RemoteApiService =
  buildRetrofit().create(RemoteApiService::class.java)

fun buildRemoteApi(): RemoteApi {
  return RemoteApiImpl(buildApiService())
}